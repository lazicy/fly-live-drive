import { Component, OnInit, Input } from '@angular/core';
import { FlightService } from 'src/app/services/flight.service';

@Component({
  selector: 'app-seats-edit',
  templateUrl: './seats-edit.component.html',
  styleUrls: ['./seats-edit.component.css']
})
export class SeatsEditComponent implements OnInit {
	seats: any;
	@Input() fId;

	constructor(private flightService: FlightService) { }

	ngOnInit() {

		console.log("fId: " + this.fId);

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
		this.seats[i].reserved = true;
	}

}
