import { Component, OnInit } from '@angular/core';
import { AvioService } from '../../services/avio.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HttpResponse } from '@angular/common/http';

@Component({
	selector: 'app-avio-profile',
	templateUrl: './avio-profile.component.html',
	styleUrls: ['./avio-profile.component.css']
})

export class AvioProfileComponent implements OnInit {
	avio: any;
	id: number;
	emptyFlightList: boolean = false;
	showFlights: boolean = false;
	constructor(private avioService: AvioService, private route: ActivatedRoute, private router: Router) {
		
		// getting route params, params is observable that unsubscribes automatically
		this.route.params.subscribe(
			(params: Params) => {
				this.id = +params['id'];
			}
		);

		if (this.id !== NaN && this.id !== undefined) {
			this.avioService.getAvio(this.id).subscribe(
				(data) => {
					this.avio = data;
				},
				(error) => {
					console.log(error);
					if (error.status === 404) {
						this.router.navigate(['avio']);
					} else {
						console.error(error);
					}
				}
			);
		}
	 }

	ngOnInit() {
		
			
	}

	onShowFlights() {
		this.showFlights = !this.showFlights;
		if (!this.avio.flights) {
			this.fetchFlights();
		}
		
	}

	fetchFlights() {
		this.avioService.getAviosFlights(this.id).subscribe(
			(data) => {
				this.avio.flights = data;
				if (this.avio.flights.length === 0) {
					this.emptyFlightList = true;
				} else {
					this.emptyFlightList = false;
				}
			},
			(error) => console.log(error)
		);
	}

}
