import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { CountryService } from 'src/app/services/country.service';
import { AvioService } from 'src/app/services/avio.service';
import { getLocaleTimeFormat, getLocaleDateTimeFormat } from '@angular/common';
import { FormGroup, FormControl, FormArray, Validators } from '@angular/forms';
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

	// show-hides
	dateValid: boolean = true;
	destValid: boolean = true;
	
	interceptionDurationValid: boolean = true;
	interceptionCitiesDistinct: boolean = true;
	interceptionValid: any = [];
	interceptionCityValid: any = [];

	// number of interceptions
	n: number = 0;

	exceeded: number = 0;

	// data 
	avio = {};
	destinations = null;
	countryList: any = [];
	destCountries: any = [];

	allTheCities: any = [];
	
	destDepartureCities: any = [];
	destLandingCities: any = [];

	// form
	flightInfoForm: FormGroup;

	totalDuration = 0;

	


	constructor(private route: ActivatedRoute, private router: Router, private countryService: CountryService, private avioService: AvioService, private flightService: FlightService) { 

		
		// getting route params, params is observable that unsubscribes automatically
		this.route.params.subscribe(
			(params: Params) => {
				this.aId = +params['aId'];
				this.fId = +params['fId'];
				console.log("AvioID: " + this.aId);
				console.log("FlightID: " + this.fId);
				
				if (isNaN(params['aId'])) {
					this.exit();
				}

				if (isNaN(params['fId']) && params['fId'] !== 'new') {
					this.exit();
				}
				
				this.editMode = params['fId'] !== 'new';
				
			
				
			}
		);

		
    
	
    
	}

	ngOnInit() {

		let interceptions = new FormArray([]);

		// init form
		this.flightInfoForm = new FormGroup({
			'departureDate': new FormControl(""),
			'departureTime': new FormControl(""),
			'departureCountryId': new FormControl(""),
			'departureCityId': new FormControl(""),
			'landingDate': new FormControl(""),
			'landingTime': new FormControl(""),
			'landingCountryId': new FormControl(""),
			'landingCityId': new FormControl(""),
			'price': new FormControl(""),
			'interceptions': interceptions,
			'numberOfSeats': new FormControl(30)
			
		});



		
 
		this.avioService.getAvio(this.aId).subscribe(
			(data) => {
					this.avio = data;
				},
			(error) => {
				console.log(error);
				if (error.status === 404) {
					this.exit();
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
				this.exit();
			} 


		}
	}

	exit() {
		this.router.navigate(['avio/admin/']);
	}

	

	onSubmitFlightInfo() {

		// print forme
		console.log(this.flightInfoForm);	
		console.log(this.interceptionValid);	
		

		

		this.allTheCities = [];
		this.dateValid = true;
		this.destValid = true;
		this.interceptionDurationValid = true;

		for (let x of this.interceptionValid) {
			x = true;
		}

		for (let x of this.interceptionCityValid) {
			x = true;
		}




		let departureTime = (this.flightInfoForm.value.departureTime === "") ? '00:00' : this.flightInfoForm.value.departureTime;
		let landingTime = (this.flightInfoForm.value.landingTime === "") ? '00:00' : this.flightInfoForm.value.landingTime;

		let departureDate = new Date(this.flightInfoForm.value.departureDate + " " + departureTime);
		let landingDate = new Date(this.flightInfoForm.value.landingDate + " " + landingTime);

		this.dateValid = this.validateDates(departureDate.getTime(), landingDate.getTime());
		this.destValid = this.validateDestinations();
		
		
		this.totalDuration = (landingDate.getTime() - departureDate.getTime())/60000;
		console.log(this.totalDuration);
		

		
		

		if (this.dateValid && this.destValid) {

			// console.log("Flight duration: " + totalDuration);
			this.interceptionDurationValid = this.validateInterceptions(this.totalDuration);

			this.interceptionCitiesDistinct = this.validateAllTheCities();

			if (this.interceptionDurationValid && this.interceptionCitiesDistinct) {
				
				let interceptionsDTO = this.formatInterceptionsDTO();

				let flight = {
					avioDTO: { id: this.aId },
					departureDate: departureDate,
					landingDate: landingDate,
					departureDestination: { cityDTO: { id: this.flightInfoForm.value.departureCityId }},
					landingDestination: { cityDTO: { id: this.flightInfoForm.value.landingCityId }},
					price: this.flightInfoForm.value.price,
					totalDuration: this.totalDuration,
					interceptionsDTO: interceptionsDTO,
					numberOfSeats: this.flightInfoForm.value.numberOfSeats
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

		} 

	}

	

	formatInterceptionsDTO() {

		let interceptionsDTO = [];

		let interceptions = this.flightInfoForm.get('interceptions').value;

		for (let i of interceptions) {
			let interception = {
				duration: i.duration,
				destinationDTO: { 
					cityDTO: {
						id: i.intCityId
					}

				}
			};

			interceptionsDTO.push(interception);

		}

		return interceptionsDTO;

	}

	validateDates(departure, landing): boolean{

		console.log(departure);
		console.log(landing);

		

		if (landing - departure >= 60*60000) {
			return true;
		} else {
			return false;
		}

	}

	validateDestinations(): boolean {

		let departureCityId = this.flightInfoForm.value.departureCityId;
		let landingCityId = this.flightInfoForm.value.landingCityId;

		if (departureCityId == landingCityId || departureCityId === undefined || landingCityId === undefined) {
			return false;
		} else {
			return true;
		}


	}

	validateInterceptions(totalDuration: number): boolean {
		let interceptions: FormArray = <FormArray>this.flightInfoForm.get('interceptions').value;
		console.log(interceptions);

		let sum = 0;
		for (let i = 0; i < interceptions.length; i++) {
			if (interceptions[i].duration <= 0) {
				this.interceptionValid[i] = false;
			} else {
				this.interceptionValid[i] = true;
			}

			if (interceptions[i].intCityId === null || interceptions[i].intCityId === undefined) {
				this.interceptionCityValid[i] = false;
			} else {
				this.interceptionCityValid[i] = true;
			}

			sum += parseInt(interceptions[i].duration);
		}


		if (sum >= totalDuration) {
			this.exceeded = sum - totalDuration;
			return false;
		} else {
			return true;
		}


	}

	validateAllTheCities() {

		let departure = this.flightInfoForm.get('departureCityId').value;
		let landing = this.flightInfoForm.get('landingCityId').value;

		let interceptions = this.flightInfoForm.get('interceptions').value;

		this.allTheCities.push(departure);
		this.allTheCities.push(landing);

		for (let i of interceptions) {
			if (i.intCityId === null || i.intCityId === undefined) {
				return false;
			}

			if (!this.allTheCities.includes(i.intCityId)) {
				this.allTheCities.push(i.intCityId);
			}
		}

		let i = this.allTheCities.length === (2+interceptions.length);

		return i;

		
		

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
		this.flightInfoForm.value.departureCityId = undefined;
		this.destDepartureCities = this.destCountries[event.target.selectedIndex].cities;
	}

	onChangeLandingCountry(event) {
		this.flightInfoForm.value.landingCityId = undefined;
		this.destLandingCities = this.destCountries[event.target.selectedIndex].cities;
	}


	onAddInterception() {
		
		this.n = this.flightInfoForm.get('interceptions').value.length;

		if (this.n >= 3) {
			return;
		} 

		(<FormArray>this.flightInfoForm.get('interceptions')).push(
			new FormGroup({
			'duration': new FormControl(0, Validators.required),
			'intCityId': new FormControl(null)
			
			})
		);

		this.interceptionValid.push(true);
		this.interceptionCityValid.push(true);
		
	
	}

	
	onDeleteInterception(index: number) {
		(<FormArray>this.flightInfoForm.get('interceptions')).removeAt(index);
		this.interceptionValid.splice(index,1);
		this.interceptionCityValid.splice(index,1);
		this.n--;
		
	}
	

}
