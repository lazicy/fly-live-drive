import { Component, OnInit, OnDestroy, EventEmitter, Output, Input } from '@angular/core';
import { AvioService } from 'src/app/services/avio.service';
import { Router } from '@angular/router';
import { CountryService } from 'src/app/services/country.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-add-destination',
  templateUrl: './add-destination.component.html',
  styleUrls: ['./add-destination.component.css']
})
export class AddDestinationComponent implements OnInit, OnDestroy {
  @Output() destinationSubmit = new EventEmitter();

  @Input() avioId: number;
  countryList: any = [];
  cityList: any = [];
  

  constructor(private avioService: AvioService, private router: Router, private countryService: CountryService) { }

  ngOnInit() {

    this.countryService.getCountries().subscribe(
			(data) => {
				this.countryList = data;
			},
			(error) => console.log(error)


		);
  }

  ngOnDestroy() {
		this.destinationSubmit.unsubscribe();
	}


  // metoda se poziva svaki put kad se promeni selekcija u html selektru za Country
	onChangeCountry(event) {
		const selectedCountryId = event.target.value;
		this.getCities(selectedCountryId);

  }

  onSubmitDestination(form: NgForm) {

    let destination = {
      avioId: this.avioId,
      cityDTO: {
          id: form.value.cityId
      }
    }

    this.avioService.saveAviosDestination(destination).subscribe(
      (response) => {
        this.destinationSubmit.emit(response);
        swal({title: "Success!", text: "Destination added", icon: "success", timer: 1500});
        form.reset();
        this.ngOnDestroy();
      },
      (error) => {swal ( "Error occured" ,  "The destination cannot be added." ,  "error" );}
    );

   

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


}
