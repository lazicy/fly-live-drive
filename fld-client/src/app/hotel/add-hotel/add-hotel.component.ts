import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { HotelService } from 'src/app/services/hotel.service';

@Component({
  selector: 'app-add-hotel',
  templateUrl: './add-hotel.component.html',
  styleUrls: ['./add-hotel.component.css']
})
export class AddHotelComponent implements OnInit {
  noStars: any;
  
  constructor(private http: HttpClient, private hotelService: HotelService) { }

  ngOnInit() {
    this.noStars = 1;
  }

  onSubmitHotel(form: NgForm) {
    const name = form.value.name;
    const address = form.value.address;
    const description = form.value.description;
    const imageURL = form.value.imageURL;
    const stars = this.noStars;

    let htl = {
      name: name,
      address: address,
      description: description,
      imageURL: imageURL,
      stars: stars,
    }
    console.log(stars);
    console.log(htl);

    this.saveHotel(htl);
    form.reset();
  }

  saveHotel(htl) {
    this.http.post("http://localhost:4200/api/hotel", htl)
    .subscribe(
      (success) => {
          alert("Hotel added!");
        }, error => { alert("An error has occured");}
    );
  }

}
