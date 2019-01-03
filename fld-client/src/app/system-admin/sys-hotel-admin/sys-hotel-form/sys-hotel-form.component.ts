import { Component, OnInit, OnDestroy, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { HotelService } from 'src/app/services/hotel.service';

@Component({
  selector: 'app-sys-hotel-form',
  templateUrl: './sys-hotel-form.component.html',
  styleUrls: ['./sys-hotel-form.component.css']
})
export class SysHotelFormComponent implements OnInit, OnDestroy {

  @Output() hotelSubmit = new EventEmitter();
  noStars: any;

  constructor(private http: HttpClient, private hotelService: HotelService) { }

  ngOnInit() {
    this.noStars = 4;
  }

  onSubmitHotel(form: NgForm) {
    const name = form.value.name;
    const address = form.value.address;
    const city = form.value.city;
    const country = form.value.country;
    const description = form.value.description;
    const himageURL = form.value.himageURL;
    const map = form.value.map;
    const stars = this.noStars;

    let htl = {
      name: name,
      address: address,
      city: city,
      country: country,
      description: description,
      hotelImageURL: himageURL,
      map: map,
      stars: stars,
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
