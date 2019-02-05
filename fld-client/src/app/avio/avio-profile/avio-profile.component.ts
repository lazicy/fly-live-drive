import { Component, OnInit } from '@angular/core';
import { AvioService } from '../../services/avio.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HttpResponse } from '@angular/common/http';
import { SafeStyle, DomSanitizer } from '@angular/platform-browser';

@Component({
	selector: 'app-avio-profile',
	templateUrl: './avio-profile.component.html',
	styleUrls: ['./avio-profile.component.css']
})

export class AvioProfileComponent implements OnInit {
	avio: any;
	flights: any = [];
	id: number;
	emptyFlightList: boolean = false;
	emptyDestinationList: boolean = false;
	map = null;
	
	showFlights: boolean = false;
	showDestinations: boolean = false;
	destCountries: any = [];
	arrows: any = [];




	constructor(private avioService: AvioService, private route: ActivatedRoute, private router: Router, public sanitizer: DomSanitizer) {
		
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
					if(this.avio.map !== "") {
						this.map = sanitizer.bypassSecurityTrustResourceUrl(this.avio.map);
					}
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
		this.avioService.getAviosDestinations(this.id).subscribe(
			(data) => {
				this.avio.destinations = data;
				this.formatCCStructure();
				for(let i=0; i<this.destCountries.length; i++) {
					this.arrows.push(false);
				}
				if(this.avio.destinations.length === 0) {
					this.emptyDestinationList = true;
				} else {
					this.emptyDestinationList = false;
				}
			},
			(error) => console.log(error)
		);
		
		
	}

	fetchFlights() {
		this.avioService.getAviosFlights(this.avio.id).subscribe(
			(data) => {
				this.flights = data;
				this.formatHoursMinutes();
			},
			(error) => console.log(error)
		);
	}
	/*
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
	}*/

	formatCCStructure() {

		this.destCountries = [];
	
		for(let city of this.avio.destinations) {
		  
		  let match = false;
		  for (let country of this.destCountries) {
			if (country.id === city.countryDTO.id) {
			
				country.cities.push(city);
				match = true;
				break;
			}
		  }
	
		  if (!match) {
			city.countryDTO.cities = [];
			city.countryDTO.cities.push(city);
			this.destCountries.push(city.countryDTO);
		  }
		}
	}

	formatHoursMinutes() {

		for (let f of this.flights) {
			f.totalDurationMins = f.totalDuration % 60;
			f.totalDurationHours = Math.floor(f.totalDuration/60);
			f.totalDurationDays = Math.floor(f.totalDurationHours/24);
			f.totalDurationHours -= f.totalDurationDays * 24;

			f.departureDate = new Date(f.departureDate);
			f.landingDate = new Date(f.landingDate);
			
		}


	}


	onToggleCountry(i) {
		this.arrows[i] = !this.arrows[i];
	}

	onToggleFlights() {
		this.showFlights = !this.showFlights;
	}
}
