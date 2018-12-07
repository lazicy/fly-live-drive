import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { HotelService } from 'src/app/services/hotel.service';

@Component({
  selector: 'app-hotel-form',
  templateUrl: './hotel-form.component.html',
  styleUrls: ['./hotel-form.component.css']
})
export class HotelFormComponent implements OnInit {

  @Output() hotelSubmit = new EventEmitter();
  noStars: any;

  constructor(private http: HttpClient, private hotelService: HotelService) { }

  ngOnInit() {
    this.noStars = 1;
  }

  onSubmitHotel(form: NgForm) {
    const name = form.value.name;
    const address = form.value.address;
    const city = form.value.city;
    const country = form.value.country;
    const description = form.value.description;
    const imageURL = form.value.imageURL;
    const stars = this.noStars;

    let htl = {
      name: name,
      address: address,
      city: city,
      country: country,
      description: description,
      imageURL: imageURL,
      stars: stars,
    }

    this.hotelService.saveHotel(htl).subscribe(
			(response) => {
				// emituje se event koji se slusa u selektoru ove komponente (child) u okviru html-a parent komponente (ovde se salje
				// response a tamo se prima $event). 
				this.hotelSubmit.emit(response);
				this.ngOnDestroy();
			},
			(error) => alert("An error has occured")
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
