import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormBuilder, FormGroup, FormControl, Validators } from '@angular/forms';
import { CountryService } from 'src/app/services/country.service';
import { Subscription } from 'rxjs';
import { AvioService } from 'src/app/services/avio.service';
import { FlightService } from 'src/app/services/flight.service';

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
	

	constructor(private countryService: CountryService, private flightService: FlightService) { 

		this.countryList = this.countryService.getCountryList();
    	this.subscription = this.countryService.countriesLoaded.subscribe(
      (countryList) => {
        this.countryList = countryList;
        
      }
    );
	}

	ngOnInit() {

		this.initForm();

	}

	ngOnDestroy() {
		this.subscription.unsubscribe();
	}

	initForm() {

		this.searchFlightForm = new FormGroup({
			'departureDate': new FormControl(["", Validators.required]),
			'returnDate': new FormControl(""),
			'fromCity': new FormControl(["", Validators.required]),
			'toCity': new FormControl(["", Validators.required]),
			'numberOfPeople': new FormControl(1),
			'tripType': new FormControl(this.tripType)
		});
	}

	onChangeTripType() {
		this.tripType = this.searchFlightForm.value.tripType;
	}

	onChangeFromCountry(event) {
		this.searchFlightForm.value.fromCity = undefined;
		this.getCities(event.target.selectedIndex+1, 'from');
	
	}

	
	onChangeToCountry(event) {
		this.searchFlightForm.value.toCity = undefined;
		this.getCities(event.target.selectedIndex+1, 'to');
	
	}

	getCities(id, which) {
		
		this.countryService.getCountysCities(id).subscribe(
			(data) => {
				if (which === 'to') {
					this.cityToList = data;
				} else if (which === 'from') {
					this.cityFromList = data;
				}
			},
			(error) => console.log(error)
		);
	}

	onSearchFlight() {
		console.log(this.searchFlightForm);

		

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

			}, (error) => {
				console.log(error);
			}

		);
		

	}

}
