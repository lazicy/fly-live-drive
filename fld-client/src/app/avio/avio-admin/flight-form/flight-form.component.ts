import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { CountryService } from 'src/app/services/country.service';
import { AvioService } from 'src/app/services/avio.service';
import { getLocaleTimeFormat, getLocaleDateTimeFormat } from '@angular/common';
import { FormGroup, FormControl } from '@angular/forms';
import { FlightService } from 'src/app/services/flight.service';

@Component({
	selector: 'app-flight-form',
	templateUrl: './flight-form.component.html',
	styleUrls: ['./flight-form.component.css']
})
export class FlightFormComponent implements OnInit {
	
	// route params
	aId: number;
	fId: number;
	
	// mode 
	editMode: boolean = false;

	// data 
	avio = {};
	destinations = null;
	countryList: any = [];
	destCountries: any = [];
	
	destDepartureCities: any = [];
	destLandingCities: any = [];

	// form
	flightInfoForm: FormGroup;


	constructor(private route: ActivatedRoute, private router: Router, private countryService: CountryService, private avioService: AvioService, private flightService: FlightService) { 

		
		// getting route params, params is observable that unsubscribes automatically
		this.route.params.subscribe(
			(params: Params) => {
				this.aId = +params['aId'];
				this.fId = +params['fId'];
				console.log("AvioID: " + this.aId);
				console.log("FlightID: " + this.fId);
				
				if (isNaN(params['aId'])) {
					this.router.navigate(['avio/admin/']);
				}

				if (isNaN(params['fId']) && params['fId'] !== 'new') {
					this.router.navigate(['avio/admin/']);
				}
				
				this.editMode = params['fId'] !== 'new';
				
				
				this.avioService.getAvio(this.aId).subscribe(
					(data) => {
			 			this.avio = data;
			  		},
					(error) => {
						console.log(error);
						if (error.status === 404) {
							this.router.navigate(['avio/admin']);
						} else {
							console.error(error);
						}
					}
		 		 );
				
			}
		);

		
    
	
    
	}

	ngOnInit() {

		// init form
		this.flightInfoForm = new FormGroup({
			'departureDate': new FormControl(""),
			'departureTime': new FormControl(""),
			'departureCityId': new FormControl(""),
			'landingDate': new FormControl(""),
			'landingTime': new FormControl(""),
			'landingCityId': new FormControl(""),
			'price': new FormControl("")
			
		});



		
 
		this.avioService.getAvio(this.aId).subscribe(
			(data) => {
					this.avio = data;
				},
			(error) => {
				console.log(error);
				if (error.status === 404) {
					this.router.navigate(['avio/admin']);
				} else {
					console.error(error);
				}
			}
		);

		this.fetchDestinations();

	}

	selectMode() {
		
		// provedi da li ima dovoljno destinacija da bi se napravio novi let - minimalno 2
		if(!this.editMode) {
			console.log(this.destinations.length);
			if (this.destinations.length < 2) {
				{swal ( "Not enough destinations" ,  "The avio company has less than 2 destinations." ,  "error" );}
			} 


		}
	}

	onSubmitFlightInfo() {

		console.log(this.flightInfoForm);

		console.log(this.flightInfoForm.value.departureDate + " " + this.flightInfoForm.value.departureTime);
		console.log(this.flightInfoForm.value.landingDate + " " + this.flightInfoForm.value.landingTime);
		
		let departureDate = new Date(this.flightInfoForm.value.departureDate + " " + this.flightInfoForm.value.departureTime);
		let landingDate = new Date(this.flightInfoForm.value.landingDate + " " + this.flightInfoForm.value.departureTime);
		

		let flight = {
			avioDTO: { id: this.aId },
			departureDate: departureDate,
			landingDate: landingDate,
			departureDestination: { cityDTO: { id: this.flightInfoForm.value.departureCityId }},
			landingDestination: { cityDTO: { id: this.flightInfoForm.value.landingCityId }},
			price: this.flightInfoForm.value.price,
			interceptionsDTO: []
		}

		this.flightService.saveFlight(flight).subscribe(
			(response) => {
				swal({title: "Success!", text: "Flight added.", icon: "success", timer: 1000});
			}, (error) => {
				{swal ( "Error occured" ,  "The company was not updated." ,  "error" );}
				console.log(error);
			}
		);
		



	}

	fetchDestinations() {
		this.avioService.getAviosDestinations(this.aId).subscribe(
			data => {
			  this.destinations = data;
			  this.destCountries = this.countryService.formatCCStructure(this.destinations);
			  this.selectMode();

			},  
			error => console.log(error)
			  
		  );
	}

	onChangeDepartureCountry(event) {
		this.destDepartureCities = this.destCountries[event.target.selectedIndex].cities;
	}

	onChangeLandingCountry(event) {
		this.destLandingCities = this.destCountries[event.target.selectedIndex].cities;
	}
	

}
