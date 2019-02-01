import { Component, OnInit, Output, EventEmitter, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { RentService } from 'src/app/services/rentacar.service';
import { CountryService } from 'src/app/services/country.service';

@Component({
  selector: 'app-sys-car-form',
  templateUrl: './sys-car-form.component.html',
  styleUrls: ['./sys-car-form.component.css']
})
export class SysCarFormComponent implements OnInit, OnDestroy {

  @Output() rentSubmit = new EventEmitter();
  countryList: any = [];
  cityList: any = [];
  
  constructor(private http: HttpClient, private service: RentService, private countryService: CountryService) { }

  ngOnInit() {
    this.countryService.getCountries().subscribe(
			(data) => {
				this.countryList = data;
			},
			(error) => console.log(error)
		);
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

  onSubmitRent(form: NgForm){
    // uzmi index iz liste na osnovu selektovanog id-a u html selectu
		let cityIndex = this.cityList.findIndex(city => city.id == form.value.cityId);
    const cityDTO = this.cityList[cityIndex];

    let rent = {
      name: form.value.name,
      adress: form.value.adress,
      cityDTO: cityDTO,
      description: form.value.description
    }

    this.service.saveRent(rent).subscribe(
      (response) => {
        this.rentSubmit.emit(response);
        swal({title: "Success!", text: "Rent-A-Car company added", icon: "success", timer: 1500});
        this.ngOnDestroy();
      },
      (error) => {swal ( "Error occured" ,  "The company was not added." ,  "error" );}
    )

    form.reset();
  }

  onReset(form: NgForm){
    form.reset();
  }

  ngOnDestroy(){
    this.rentSubmit.unsubscribe();
  }
}
