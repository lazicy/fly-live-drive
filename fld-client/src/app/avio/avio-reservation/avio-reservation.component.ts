import { Component, OnInit, OnDestroy } from '@angular/core';
import { ReservationFlightService } from 'src/app/services/reservation-flight.service';
import { FlightService } from 'src/app/services/flight.service';

@Component({
  selector: 'app-avio-reservation',
  templateUrl: './avio-reservation.component.html',
  styleUrls: ['./avio-reservation.component.css']
})
export class AvioReservationComponent implements OnInit, OnDestroy {
 
	departureFlight = null;
	returnFlight = null;

	constructor(private resFService: ReservationFlightService, private flightService: FlightService) {
		
		this.flightService.getFlight(this.resFService.departureFlightId).subscribe(
			(data) => {
				this.departureFlight = data;
			}, (error) => {

				console.log(error);
			}
		);

		console.log(this.resFService.returnFlightId);

		
		this.flightService.getFlight(this.resFService.returnFlightId).subscribe(
			(data) => {
				this.returnFlight = data;
			}, (error) => {

				console.log(error);
			}
		);
	}

	ngOnInit() {
	
	}

	ngOnDestroy(): void {

	}

}
