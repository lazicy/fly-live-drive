import { Component, OnInit, OnDestroy } from '@angular/core';
import { ReservationFlightService } from 'src/app/services/reservation-flight.service';
import { FlightService } from 'src/app/services/flight.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormGroup, FormControl, Validators } from '@angular/forms';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-avio-reservation',
  templateUrl: './avio-reservation.component.html',
  styleUrls: ['./avio-reservation.component.css']
})
export class AvioReservationComponent implements OnInit, OnDestroy {
 
	departureFlight = null;
	returnFlight = null;

	showDepartureSeats: boolean = false;
	showReturnSeats: boolean = false;

	selectedDepartureSeats: any = [];
	selectedReturnSeats: any = [];

	// ostali putnici koji se dodaju manuelno
	others: any = [];

	// main form
	flightResForm: FormGroup;
	
	// logged user
	loggedUser = null;

	// ako je sve spremno za rezervaciju
	allSet: boolean = false;

	totalPrice = 0;

	typeOfTrip: string;

	res = null;


	constructor(private resFService: ReservationFlightService, private flightService: FlightService, 
		private route: ActivatedRoute, private router: Router, private authService: AuthService, private userService: UserService) {

		if (this.resFService.returnFlightId == -1) {
			this.typeOfTrip = "one-way";
		} else {
			this.typeOfTrip = "round";
		}
		
		this.flightService.getFlight(this.resFService.departureFlightId).subscribe(
			(data) => {
				this.departureFlight = data;
			}, (error) => {

				console.log(error);
			}
		);

	
		if (this.typeOfTrip === "round") {

			this.flightService.getFlight(this.resFService.returnFlightId).subscribe(
				(data) => {
					this.returnFlight = data;
				}, (error) => {
					
					console.log(error);
				}
			);
		}
	}

	ngOnInit() {

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
		
		this.flightResForm = new FormGroup({
			'numberOfPeople': new FormControl(1),
			'loggedUserPassportNumber': new FormControl("", Validators.required)
		});
	}

	onSelectDepartureSeats() {
		this.showDepartureSeats = true;
	}

	onCloseDepartureSeats() {
		this.showDepartureSeats = false;
	}


	onSelectReturnSeats() {
		this.showReturnSeats = true;
	}

	onCloseReturnSeats() {
		this.showReturnSeats = false;
	}

	ngOnDestroy(): void {

	}

	onSeatsDepartureConfirm(event) {

		this.showDepartureSeats = false;

		console.log("onSeatsDepartureConfirm(event):");
		console.log(event);
		// provera da li je doslo do greske
		if (event == -1) {
			this.router.navigate(['avio']);
		} else {
			this.selectedDepartureSeats = event;

			this.formTheForm();
			this.checkIfAllSet();
		}

	}

	onSeatsReturnConfirm(event) {

		this.showReturnSeats = false;

		console.log("onSeatReturnConfirm(event):");
		console.log(event);
		// provera da li je doslo do greske
		if (event == -1) {
			this.router.navigate(['avio']);
		} else {
			this.selectedReturnSeats = event;

			this.formTheForm();
			
			this.checkIfAllSet();

		}

	}

	formTheForm() {

		this.others = [];

		for (let i = 0; i < this.flightResForm.value.numberOfPeople-1; i++) {
			let other = {
				firstName: "Perica" + i,
				lastName: "Perunic" + i,
				passportNumber: "123456",
				
			}

			this.others.push(other);

		
		}

		let reserver = {
			firstName: this.loggedUser.firstName,
			lastName: this.loggedUser.lastName,
			passportNumber: this.flightResForm.value.passportNumber,
			username: this.loggedUser.username
		}


		this.others.push(reserver);

		console.log("Others");
		console.log(this.others);
		
	}

	
	checkIfAllSet() {

		this.allSet = false;

		let nOp = this.flightResForm.value.numberOfPeople;

		if (this.returnFlight == null) {
			if (this.selectedDepartureSeats.length == nOp) {
				
				console.log("SelectedDepartureSeats.length = " + this.selectedDepartureSeats.length);
				this.allSet = true;
			}
		} else {
			console.log("SelectedDepartureSeats.length = " + this.selectedDepartureSeats.length);
			console.log("SelectedReturnSeats.length = " + this.selectedReturnSeats.length);
			

			if (this.selectedDepartureSeats.length == nOp && this.selectedReturnSeats.length == nOp) {
				this.allSet = true;
			}

		}

		if (this.returnFlight == null) {
			this.totalPrice = this.departureFlight.price * this.flightResForm.value.numberOfPeople;
		} else {
			this.totalPrice = this.flightResForm.value.numberOfPeople*(this.departureFlight.price + this.returnFlight.price);
		}

		
		console.log("allSet?" + this.allSet);

	
	

	}

	// validateForms() {
	// 	// for now
	// 	if (this.flightResForm.value.loggedUserPassportNumber != "") {
	// 		return true;
	// 	} else {
	// 		return false;
	// 	}
	// }

	onSubmitReservation() {
		const tod = new Date();
		const today = tod.toISOString().split('T')[0];
		const totalPrice = 0;
		
		
		let fr = {
			tripType: this.typeOfTrip,
			reservationDate: today,
			departureFlightId: this.departureFlight.id,
			returnFlightId: -1,
			username: this.loggedUser.username,
			totalPrice: this.totalPrice,
			departureSeatsDTO: this.selectedDepartureSeats,
			returnSeatsDTO: [],
			passengers: this.others
		}

		
		if (this.typeOfTrip === "round") {
			fr.returnFlightId = this.returnFlight.id;
			fr.returnSeatsDTO = this.selectedReturnSeats;
		} 

		if (this.allSet) {

			this.resFService.saveFlightReservation(fr).subscribe(
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
			
	}
		