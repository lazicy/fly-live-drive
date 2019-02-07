import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { CountryService } from 'src/app/services/country.service';
import { Subscription } from 'rxjs';
import { AvioService } from 'src/app/services/avio.service';
import { FlightService } from 'src/app/services/flight.service';
import { ReservationFlightService } from 'src/app/services/reservation-flight.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-avio-homepage',
  templateUrl: './avio-homepage.component.html',
  styleUrls: ['./avio-homepage.component.css']
})
export class AvioHomepageComponent implements OnInit, OnDestroy {

	searchFlightForm: FormGroup;
	subscription: Subscription;

	searchResults: any = [];

	tripType: string = 'one-way';
	countryList: any = [];
	cityFromList: any = [];
	cityToList: any = [];

	fromCity;
	toCity;

	tod: Date = new Date();
	tom: Date = new Date();

	fromCountryStart = 19;
	toCountryStart = 22;

	showList: boolean = true;
	loadingResults: boolean = false;

	// lists of boolean for selected
	selectedDeparture: any = []
	selectedReturn: any = []

	departureFlight = null;
	returnFlight = null;

	showReserveControl: boolean = false;
	
	

	constructor(private countryService: CountryService, private flightService: FlightService, private resFService: ReservationFlightService, private route: ActivatedRoute, private router: Router) { 

		this.countryList = this.countryService.getCountryList();
    	this.subscription = this.countryService.countriesLoaded.subscribe(
				(countryList) => {
					this.countryList = countryList;
					
				}
		);
		
		this.getCities(this.fromCountryStart, 'from');
		this.getCities(this.toCountryStart, 'to');
		
	}

	ngOnInit() {

		this.initForm();

	}

	ngOnDestroy() {
		this.subscription.unsubscribe();
	}

	initForm() {

		const today = this.tod.toISOString().split('T')[0];
		this.tom.setDate(this.tod.getDate()+1);
		const tomorrow = this.tom.toISOString().split('T')[0];

		this.searchFlightForm = new FormGroup({
			'departureDate': new FormControl(['', Validators.required]),
			'returnDate': new FormControl(''),
			'fromCity': new FormControl(['', Validators.required]),
			'toCity': new FormControl(['', Validators.required]),
			'numberOfPeople': new FormControl(1),
			'tripType': new FormControl(this.tripType),
			'fromCountry': new FormControl(this.fromCountryStart),
			'toCountry': new FormControl(this.toCountryStart)
		});

		this.searchFlightForm.controls['departureDate'].setValue(today);
		this.searchFlightForm.controls['returnDate'].setValue(tomorrow);
		
	}

	onChangeTripType() {
		this.tripType = this.searchFlightForm.value.tripType;
	}

	onChangeFromCountry(event) {
		this.getCities(event.target.selectedIndex+1, 'from');
	
	}

	
	onChangeToCountry(event) {
		this.getCities(event.target.selectedIndex+1, 'to');
	
	}

	getCities(id, which) {
		
		this.countryService.getCountysCities(id).subscribe(
			(data) => {
				if (which === 'to') {
					this.cityToList = data;
					this.searchFlightForm.controls['toCity'].setValue(data[0].id);
				} else if (which === 'from') {
					this.cityFromList = data;
					
					this.searchFlightForm.controls['fromCity'].setValue(data[0].id);
				}
			},
			(error) => console.log(error)
		);
	}

	onSearchFlight() {
		console.log(this.searchFlightForm);



		this.toCity = this.cityToList[this.countryService.findCityIndex(this.searchFlightForm.value.toCity, this.cityToList)];
		this.fromCity = this.cityFromList[this.countryService.findCityIndex(this.searchFlightForm.value.fromCity, this.cityFromList)];

		this.showList = false;
		this.loadingResults = true;

		let searchParams = {
			departureDate: this.searchFlightForm.value.departureDate,
			returnDate: this.searchFlightForm.value.returnDate,
			fromCity: { id: this.searchFlightForm.value.fromCity },
			toCity: { id: this.searchFlightForm.value.toCity},
			numberOfPeople: parseInt(this.searchFlightForm.value.numberOfPeople),
			tripType: this.searchFlightForm.value.tripType			
		}

		this.flightService.searchFlights(searchParams).subscribe(

			(data) => {
				this.searchResults = data;
				this.initSelectedLists();
				this.loadingResults = false;
				
			}, (error) => {
				console.log(error);
				
				this.showList = true;
			}

		);
		

	}

	initSelectedLists() {

		this.selectedDeparture = [];
		this.selectedReturn = [];
		this.departureFlight = null;
		this.returnFlight = null;

		for (let i = 0; i < this.searchResults.departureFlights.length; i++) {
			this.selectedDeparture.push(false);
		}

		for (let i = 0; i < this.searchResults.returnFlights.length; i++) {
			this.selectedReturn.push(false);
		}

	}


	selectDepartureFlight(iDf) {

		

		for (let i = 0; i < this.searchResults.departureFlights.length; i++) {
			if (i == iDf) {

				if (this.selectedDeparture[i] == false) {
					this.selectedDeparture[i] = true;
					this.departureFlight = this.searchResults.departureFlights[i];
				} else {
					this.selectedDeparture[i] = false;
					this.departureFlight = null;
				}
			} else {
				this.selectedDeparture[i] = false;
			}
			
		}


	}


	
	selectReturnFlight(iRf) {

		
		for (let i = 0; i < this.searchResults.returnFlights.length; i++) {
			if (i == iRf) {
				
				if (this.selectedReturn[i] == false) {
					this.selectedReturn[i] = true;
					this.returnFlight = this.searchResults.returnFlights[i];
				} else {
					this.selectedReturn[i] = false;
					this.returnFlight = null;
				}
			} else {
				this.selectedReturn[i] = false;
			}
			
		}

	}

	onReserveOneWay() {
		
		if (this.departureFlight == null) {
			return;
		}

		this.resFService.departureFlightId = this.departureFlight.id;

		console.log(this.departureFlight);

		// just in case
		this.resFService.returnFlightId = -1;

		
		this.router.navigate(['avio/reservation']);
		


	}

	onReserveRound() {

		
		if (this.departureFlight == null || this.returnFlight == null) {
			return;
		}

		this.resFService.departureFlightId = this.departureFlight.id;
		this.resFService.returnFlightId = this.returnFlight.id;
		console.log("ajmo: " + this.returnFlight.id);

		
		this.router.navigate(['avio/reservation']);
		
	}
}
