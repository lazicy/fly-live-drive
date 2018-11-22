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

  constructor(private http: HttpClient, private hotelService: HotelService) { }

  ngOnInit() {
  }

  onSubmitHotel(form: NgForm) {
    const name = form.value.name;
    const address = form.value.address;
    const description = form.value.description;

    let htl = {
      name: name,
      address: address,
      description: description
    }

    console.log(htl);

    this.saveHotel(htl);
    form.reset();
  }

  saveHotel(htl) {
    this.http.post("http://localhost:4200/api/hotel", htl)
    .subscribe(
      (success) => {
          console.log(success);
        }, error => { alert("An error has occured");
          console.log(error); }
    );
  }

}
