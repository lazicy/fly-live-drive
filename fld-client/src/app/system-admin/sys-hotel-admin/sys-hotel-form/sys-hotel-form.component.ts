import { Component, OnInit, OnDestroy, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { HotelService } from 'src/app/services/hotel.service';
import { CountryService } from 'src/app/services/country.service';

@Component({
  selector: 'app-sys-hotel-form',
  templateUrl: './sys-hotel-form.component.html',
  styleUrls: ['./sys-hotel-form.component.css']
})
export class SysHotelFormComponent implements OnInit, OnDestroy {

  @Output() hotelSubmit = new EventEmitter();
  noStars: any;
  countryList: any = [];
	cityList: any = [];

  constructor(private http: HttpClient, private hotelService: HotelService, private countryService: CountryService) { }

  ngOnInit() {
    this.noStars = 1;
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

  onSubmitHotel(form: NgForm) {

    // uzmi index iz liste na osnovu selektovanog id-a u html selectu
		let cityIndex = this.cityList.findIndex(city => city.id == form.value.cityId);
    const cityDTO = this.cityList[cityIndex];

    let htl = {
      name: form.value.name,
      address: form.value.address,
      cityDTO: cityDTO,
      description: form.value.description,
      hotelImageURL: form.value.himageURL,
      map: form.value.map,
      stars: this.noStars
    }

    this.hotelService.saveHotel(htl).subscribe(
			(response) => {
				// emituje se event koji se slusa u selektoru ove komponente (child) u okviru html-a parent komponente (ovde se salje
				// response a tamo se prima $event). 
        this.hotelSubmit.emit(response);
        swal({title: "Success!", text: "Hotel added", icon: "success", timer: 1500});
				this.ngOnDestroy();
			},
			(error) => {swal ( "Error occured" ,  "The hotel was not added." ,  "error" );}
    );
    
    form.reset();
  }

  onReset(form: NgForm) {
    form.reset();
    this.noStars = 1;
  }

  ngOnDestroy() {
		this.hotelSubmit.unsubscribe();
	}
}
