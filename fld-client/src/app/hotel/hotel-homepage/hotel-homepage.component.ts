import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-hotel-homepage',
  templateUrl: './hotel-homepage.component.html',
  styleUrls: ['./hotel-homepage.component.css']
})
export class HotelHomepageComponent implements OnInit {
  tod: Date = new Date();
  tom: Date = new Date();
  today: any;
  tomorrow: any;
  hotelSearch: any;
  notFound: any;
  constructor(private hotelService: HotelService) {
  }

  ngOnInit() {
    this.tom.setDate(this.tod.getDate() + 1);
    this.today = this.tod.toISOString().split('T')[0];
    this.tomorrow = this.tom.toISOString().split('T')[0];
  }

  onSearchHotels(form: NgForm) {
    const name = form.value.search;

    //uraditi search
    this.hotelService.searchHotel(name).subscribe(
      (data) => {
        this.hotelSearch = data;
        if(this.hotelSearch.length === 0) {
          this.notFound = true;
        }
      },
      (error) => alert("Error: " + error)
    );
  }
}
