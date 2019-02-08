import { Component, OnInit, Input, Output, OnDestroy, EventEmitter } from '@angular/core';
import { FlightService } from 'src/app/services/flight.service';

@Component({
  selector: 'app-seats-select',
  templateUrl: './seats-select.component.html',
  styleUrls: ['./seats-select.component.css']
})
export class SeatsSelectComponent implements OnInit, OnDestroy {

	selectedSeats: any = [];
	seats: any;
	seatsCheck: any = [];
	@Input() fId;
	
	@Input() numberOfPeople;
	
	// indikator poredjenja sa check requestom, inicijalno true
	allValid = true;
	allTaken = false;

	selected = [];
	
	@Output() seatsConfirm = new EventEmitter();

	constructor(private flightService: FlightService) { }

	ngOnInit() {

		console.log("fId: " + this.fId);
		console.log("SeatsSelectOnInit(), numberOfPeople: " + this.numberOfPeople);
		

		if(!isNaN(this.fId)) {
			this.flightService.getFlightSeats(this.fId).subscribe(
				(data) => {
					this.seats = data;
					this.fillEmptyPlaces();
					console.log(this.seats);
				}, (error) => {
					console.log(error);
				}

			);

		}
		

	}

	fillEmptyPlaces() {
		let howMany = 6 - (this.seats.length % 6);

		const invisibleSeat = {
			row: -1,
			reserved: true,
			position: 'X',
			selected: false,
			id: -1
		} 

		while (howMany > 0 && howMany < 6) {
			this.seats.push(invisibleSeat);
			howMany--;
		}

	}

	onReserveSeat(i) {
		
		if (!this.seats[i].selected && this.selectedSeats.length >= this.numberOfPeople) {
			return;
		}

		this.seats[i].selected = this.seats[i].selected ? false : true;

		

		if (this.seats[i].selected) {
			this.selectedSeats.push(this.seats[i]);
		} else {
			console.log("spliced index: " + i);
			this.selectedSeats.splice(this.selectedSeats.findIndex(seat => seat.id == i), 1);
		}

		console.log(this.selectedSeats);
	}

	onProceed() {
		// provera da li se u medjuvremenu desila rezervacija od strane nekog drugog korisnika

		this.flightService.getFlightSeats(this.fId).subscribe(
			data => {

				this.seatsCheck = data;
				this.checkAndUpdate();

			}, error => {
				console.log(error);

			}
		);
	}

	checkAndUpdate() {

		this.allValid = true;

		this.saveSelected();

		let resCount = 0;

		// assign to a new seats list
		this.seats = this.seatsCheck;
		this.fillEmptyPlaces();

		console.log("selected: ");
		console.log(this.selected);
		for (let i = 0; i < this.selected.length; i++) {
			// ukoliko je u medjuvremenu obrisano ili rezervisano
			let index = this.selected[i];
			if (this.seats[index] == null || this.seats[index].reserved) {
				this.allValid = false;
			} else {
				console.log("asign to true");
				this.seats[index].selected = true;
			}
		}

		

		// izbroj da li su sva rezervisana
		for (let i = 0; i < this.seats[i].length; i++) {
			
			if (this.seats[i].reserved) {
				resCount++;
			}

		}

		if (resCount == this.seats.length) {
			this.allTaken = true;
		}

		if (this.allTaken) {
			{swal ( "We are sorry!" ,  "During your slecting, somebody else took your seats or they've been deleted, and all the seats are reserved on this flight. 😞" );}
			this.seatsConfirm.emit("-1");
			this.ngOnDestroy();

			
		}

		if(!this.allValid) {
			{swal ( "Please take other seats!" ,  "During your slecting, somebody else took your seats or it's been deleted, what a bummer! Please select other seats." );}
		}

		this.seatsConfirm.emit(this.selectedSeats);
		this.ngOnDestroy();


	}

	saveSelected() {

		this.selected = [];

		for (let i = 0; i < this.seats.length; i++) {
			if (this.seats[i].selected == true) {
				this.selected.push(i);
			}

		}
	}

	ngOnDestroy() {
		this.seatsConfirm.unsubscribe();
	}


}