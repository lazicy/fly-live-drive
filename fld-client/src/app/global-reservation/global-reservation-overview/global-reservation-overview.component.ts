import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { ReservationFlightService } from 'src/app/services/reservation-flight.service';

@Component({
	selector: 'app-global-reservation-overview',
	templateUrl: './global-reservation-overview.component.html',
	styleUrls: ['./global-reservation-overview.component.css']
})
export class GlobalReservationOverviewComponent implements OnInit {

	constructor(private route: ActivatedRoute, private router: Router, private reservationService: ReservationFlightService) { }
	id;
	globalReservation = null;

	ngOnInit() {

		// getting route params, params is observable that unsubscribes automatically
		this.route.params.subscribe(
			(params: Params) => {
				this.id = +params['id'];
			}
		);

		if (this.id !== NaN && this.id !== undefined) {
			this.reservationService.getGlobalReservation(this.id).subscribe(
			
				(data) => {
					this.globalReservation = data;
					console.log(this.globalReservation);

				}, (error) => {

				}
			
			);



		} else {
			
			this.router.navigate(['']);
		}
	}

}
