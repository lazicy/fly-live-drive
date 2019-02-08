import { Component, OnInit, Input } from '@angular/core';
import { AvioService } from 'src/app/services/avio.service';
import { FlightService } from 'src/app/services/flight.service';
import { UtilService } from 'src/app/services/util.service';
import { UserService } from 'src/app/services/user.service';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { ReservationFlightService } from 'src/app/services/reservation-flight.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-flightlist',
  templateUrl: './flightlist.component.html',
  styleUrls: ['./flightlist.component.css']
})

export class FlightlistComponent implements OnInit {
	flights: any = [];
	@Input() avioId: number;
	@Input() flightList: any = []

	quickResForm: FormGroup;

	searchList: boolean = false;
	whichOnes = false;

	showQuickReserve = false;
	quickReserveFlight = null;
	seatsOnDiscount = [];

	totalPrice = 0;

	res = null;

	// logged user
	loggedUser = null;

	constructor(private avioService: AvioService, private flightSerice: FlightService, private utilService: UtilService, private userService: UserService, private resFService: ReservationFlightService, private router: Router) { }

	ngOnInit() {

		if (this.avioId != -1) {
			this.fetchFlights();
		} else {
			this.flights = this.flightList;
			console.log(this.flightList);
			this.formatDateAndTime();
			this.searchList = true;

		}

		this.initForm();

		// dinamicki napraviti polja
		this.userService.getUserInfo().subscribe(
			data => {
				console.log("getting logged user...");
				this.loggedUser = data;
				console.log(this.loggedUser);
			}, error => {
				console.log(error);
			}

		);

	}


	initForm() {
		this.quickResForm = new FormGroup({
			'loggedUserPassportNumber': new FormControl("", Validators.required),
			'selectedSeat': new FormControl("", Validators.required)
	});


	}

	fetchFlights() {
		this.avioService.getAviosFlights(this.avioId).subscribe(
			(data) => {
				this.flights = data;
				this.formatDateAndTime();
			},
			(error) => console.log(error)
		);
	}
	
	formatDateAndTime() {

		for (let f of this.flights) {

			f.totalPrice = Math.floor(0.9 * f.totalPrice);
			f.totalDurationMins = f.totalDuration % 60;
			f.totalDurationHours = Math.floor(f.totalDuration/60);
			f.totalDurationDays = Math.floor(f.totalDurationHours/24);
			f.totalDurationHours -= f.totalDurationDays * 24;

			let fd = new Date(f.departureDate);
			let fl = new Date(f.landingDate);

			f.departureDate = this.utilService.monthsFull[fd.getMonth()] + " " + fd.getDate() + ", " + fd.getFullYear();
			f.landingDate = this.utilService.monthsFull[fl.getMonth()] + " " + fl.getDate() + ", " + fl.getFullYear();
			
			if (fd.getMinutes() < 10) {
				f.departureTime = fd.getHours() + ":0" + fd.getMinutes();
				
			} else {
				f.departureTime = fd.getHours() + ":" + fd.getMinutes();
			}


			if (fl.getMinutes() < 10) {
				f.landingTime = fl.getHours() + ":0" + fl.getMinutes();
				
			} else {
				f.landingTime = fl.getHours() + ":" + fl.getMinutes();
			}
		}
	}

	calculateAvailableSeats() {

		

	}

	overInterceptions() {
		this.whichOnes = true;
	}

	outInterceptions() {
		this.whichOnes = false;
	}

	onShowQuickReserve(f) {
		this.quickReserveFlight = f;
		this.showQuickReserve = true;
		this.totalPrice = Math.floor(f.price);
		
		this.getSeatsOnDiscount(this.quickReserveFlight);
	}

	onCloseQuickReserve(f) {
		this.quickReserveFlight = null;
		this.showQuickReserve = false;
	}

	getSeatsOnDiscount(f) {

		this.seatsOnDiscount = f.seatsDTO.filter(seat => seat.discount > 0 && !seat.reserved);

		console.log("Seats on discount: ");
		console.log(this.seatsOnDiscount);


	}

	onQuickReserve() {

		const tod = new Date();
		const today = tod.toISOString().split('T')[0];

		console.log(this.quickResForm);
		
		console.log(this.quickResForm.value.selectedSeat);
		let onlyOne = this.seatsOnDiscount.filter(seat => seat.id == this.quickResForm.value.selectedSeat);
		console.log(onlyOne);
		
		let fr = {
			tripType: "one-way",
			reservationDate: today,
			departureFlightId: this.quickReserveFlight.id,
			returnFlightId: -1,
			username: this.loggedUser.username,
			totalPrice: this.totalPrice,
			departureSeatsDTO: onlyOne,
			returnSeatsDTO: [],
			passengers: []
		}

		this.resFService.saveQuickFlightReservation(fr).subscribe(
			data => {
				this.res = data;
				let bonus = this.res.bonusPointsEarned;

				if (bonus > 0) {
					swal({title: "Congrats!", text: " Your flights are booked and you have earned " + bonus + " bonus points!", icon: "success", timer: 1500});
				} else {
					swal({title: "Congrats!", text: " Your flights are booked!", icon: "success", timer: 1500});
				}

				
				this.router.navigate(['globalreservation', this.res.globalReservationId] );

			}, error => {
				{swal ( "Please check other seats!" ,  "It seems that the seats you choosed, someone got before you. 😔 Please try again." );}
			}
			);
			
		 }


	}

	

