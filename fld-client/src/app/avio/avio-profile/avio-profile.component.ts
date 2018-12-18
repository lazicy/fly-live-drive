import { Component, OnInit } from '@angular/core';
import { AvioService } from '../../services/avio.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
	selector: 'app-avio-profile',
	templateUrl: './avio-profile.component.html',
	styleUrls: ['./avio-profile.component.css']
})

export class AvioProfileComponent implements OnInit {
	avio: any;
	id: number;
	emptyFlightList: boolean = false;
	emptyDestinationList: boolean = false;
	
	showFlights: boolean = false;
	showDestinations: boolean = false;

	br_zvezdica: number;
	zvezdice: number[] = [];
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
		this.br_zvezdica = 4;
		let i = 0;

		while (i < this.br_zvezdica) { this.zvezdice.push(1); i++; }
		
			
	}

	onShowFlights() {
		this.showFlights = !this.showFlights;
		// if (!this.avio.flights) {
		// 	this.fetchFlights();
		// }

		if (this.showFlights) {
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

	onShowDestinations() {
		this.showDestinations = !this.showDestinations;
		// if (!this.avio.destinations) {
		// 	this.fetchDestinations();
		// }

		if (this.showDestinations) {
			this.fetchDestinations();
		}
	}

	fetchDestinations() {
		this.avioService.getAviosDestinations(this.id).subscribe(
			(data) => {
				this.avio.destinations = data;
				if(this.avio.destinations === 0) {
					this.emptyDestinationList = true;
				} else {
					this.emptyDestinationList = false;
				}
			},
			(error) => console.log(error)
		
			
		);
	}

	onSubmitDestination(form: NgForm) {
		const name = form.value.name;
		const country = form.value.country;
		
		let destination = {
			name: name,
			country: country
		}


		this.avioService.saveAviosDestination(this.avio.id, destination).subscribe(
			(response) => console.log(response),
			(error) => {	
				// console.log(error.status); 
				if (error.status === 409) {
					console.log("Already exists city " + destination.name + " in " + destination.country);
				}
			}
		);
		
	}

	

}
