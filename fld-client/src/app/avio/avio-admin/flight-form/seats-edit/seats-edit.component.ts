import { Component, OnInit, Input } from '@angular/core';
import { FlightService } from 'src/app/services/flight.service';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-seats-edit',
  templateUrl: './seats-edit.component.html',
  styleUrls: ['./seats-edit.component.css']
})
export class SeatsEditComponent implements OnInit {
	seats: any;
	discounts = [];
	discountForm: FormGroup;
	@Input() fId;

	selectedSeats: any = [];
	constructor(private flightService: FlightService) { }

	ngOnInit() {

		console.log("fId: " + this.fId);

		this.fetchSeats();
		this.initForm();

		

	}

	initForm() {

		for (let i = 1; i <= 3; i++) {
			let discount = {
				how: (i/10),
				fullFormat: i*10 + "%"
			}

			console.log("made discount: ")

			this.discounts.push(discount);
		}

		console.log(this.discounts);




		this.discountForm = new FormGroup({
			'dsc': new FormControl(0.1)
		});
	}

	fetchSeats() {

		if(!isNaN(this.fId)) {
			this.flightService.getFlightSeats(this.fId).subscribe(
				(data) => {
					this.seats = data;
					// this.fillEmptyPlaces();
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
			reserved: false,
			position: 'X',
			id: -1
		} 

		while (howMany > 0 && howMany < 6) {
			this.seats.push(invisibleSeat);
			howMany--;
		}

	}

	onReserveSeat(i) {
		
		if (this.seats[i].reserved || this.seats[i].deleted) {
			return;
		}


		this.seats[i].selected = this.seats[i].selected ? false : true;
		
		

		
		if (this.seats[i].selected) {
			this.selectedSeats.push(this.seats[i]);
		} else {
			console.log("spliced index: " + i);
			this.selectedSeats.splice(this.selectedSeats.findIndex(seat => seat.id == i), 1);
		}


	}

	onRemoveSeats() {

		console.log("Seats to be removed: ");
		console.log(this.selectedSeats);

		this.flightService.deleteSeats(this.selectedSeats).subscribe(
			(data) => {
				swal({title: "Seats removed!", text: "Selected seats are successfully removed.", icon: "success", timer: 1500});
				
				this.selectedSeats = this.selectedSeats.map(seat => seat.deleted = true);
				this.selectedSeats.splice(0, this.selectedSeats.length);

			}, (error) => {
				console.log(error);
				if (error.status == 409) {
					{swal ( "Selected seats can not be removed!" ,  "During your selecting, a reservation with the same seats has been recieved." );}

					this.fetchSeats();
				}
			}
		);

	}

	onSetDiscount() {

	}

}
