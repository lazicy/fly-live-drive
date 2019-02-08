import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RentService } from 'src/app/services/rentacar.service';
import { DataService } from 'src/app/services/data.service';
import { RentACar } from 'src/app/model/rentacar';
import { NumberValueAccessor } from '@angular/forms/src/directives';
import { CountryService } from 'src/app/services/country.service';
import { ActivatedRoute, Params } from '@angular/router';

@Component({
  selector: 'app-rent-form',
  templateUrl: './rent-form.component.html',
  styleUrls: ['./rent-form.component.css']
})
export class RentFormComponent implements OnInit {

  @Output() rentSubmit = new EventEmitter(); //???

  cityList: any = [];
  countryList: any = [];
  rent: any;

  name: string;
  address: string;
  addressOnMap: string;
  id: Number;
  selectedCountry: Number;
  selectedCity: Number;
  description: string;

  constructor(private route: ActivatedRoute,private service: RentService, private countryService: CountryService) { 
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params['id'];
      }
    ); 
  }

  ngOnInit() {
    this.countryService.getCountries().subscribe(
      (data) => {
        this.countryList = data;
      },
      (error) => console.log(error)
    )

    this.service.getRent(this.id).subscribe(
      (data) => {
        this.rent = data;
        this.fillForm();
      }
    )
  }
  fillForm(){
    this.getCities(this.rent.cityDTO.countryDTO.id);
    this.address = this.rent.address;
    this.name = this.rent.name;
    this.addressOnMap = this.rent.addressOnMap;
    this.description = this.rent.description
    this.selectedCity = this.rent.cityDTO.id;
    this.selectedCountry = this.rent.cityDTO.countryDTO.id;
  }

  onSubmitRent(form: NgForm){
    let cityIndex = this.cityList.findIndex(city => city.id == this.selectedCity);
    const cityDTO = this.cityList[cityIndex];
    var rent = {
      id: +this.id,
      name: this.name,
      address: this.address,
      addressOnMap: this.addressOnMap,
      cityDTO: cityDTO,
      description: this.description,
    }

    this.service.editRent(rent).subscribe(
      (response) => {
        this.rentSubmit.emit(response);
        this.ngOnDestroy();
      },
      (error) => alert(error)
    )

    form.reset();
  }

  onReset(form: NgForm){
    form.reset();
  }
  
  // metoda se poziva svaki put kad se promeni selekcija u html selektru za Country
  onChangeCountry(event) {
		const selectedCountryId = event.target.value;
		this.getCities(selectedCountryId);
  }

  // uzima i dodeljuje vrednost listi gradova koja se trenutno prikazuje u formi
	getCities(id) {
		this.countryService.getCountysCities(id).subscribe(
			(data) => {
				this.cityList = data;
			},
			(error) => console.log(error)
		);
	}

  ngOnDestroy(){
    this.rentSubmit.unsubscribe();
  }

}
