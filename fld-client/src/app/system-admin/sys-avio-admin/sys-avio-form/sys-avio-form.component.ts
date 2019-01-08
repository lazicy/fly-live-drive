import { Component, OnInit, EventEmitter, Output, Input, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { AvioService } from 'src/app/services/avio.service';
import { CountryService } from 'src/app/services/country.service';

import { Router } from '@angular/router';

@Component({
  selector: 'app-sys-avio-form',
  templateUrl: './sys-avio-form.component.html',
  styleUrls: ['./sys-avio-form.component.css']
})
export class SysAvioFormComponent implements OnInit, OnDestroy {
  @Output() avioSubmit = new EventEmitter();
	destinations: any = [];
	
	countryList: any = [];
	cityList: any = [];
	

	constructor(private avioService: AvioService, private router: Router, private countryService: CountryService) { }

	ngOnInit() {

		console.log("Sys avio form init");
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

	onSubmitAvio(form: NgForm) {

		// uzmi index iz liste na osnovu selektovanog id-a u html selectu
		let cityIndex = this.cityList.findIndex(city => city.id == form.value.cityId);
		const cityDTO = this.cityList[cityIndex];
		
		let avio = {
			name: form.value.name,
			address: form.value.address,
			cityDTO: cityDTO,
			map: form.value.map,
			description: form.value.description
		}

		this.avioService.saveAvio(avio).subscribe(
			(response) => {
				// emituje se event koji se slusa u selektoru ove komponente (child) u okviru html-a parent komponente (ovde se salje
				// response a tamo se prima $event). 
				this.avioSubmit.emit(response);
				swal({title: "Success!", text: "Avio company added", icon: "success", timer: 1500});
				this.ngOnDestroy();
			},
			(error) => {swal ( "Error occured" ,  "The company was not added." ,  "error" );}
		);

		form.reset();

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


	onReset(form: NgForm) {
		form.reset();
	}

	ngOnDestroy() {
		this.avioSubmit.unsubscribe();
	}



}
