import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';

@Component({
  selector: 'app-hotel-homepage',
  templateUrl: './hotel-homepage.component.html',
  styleUrls: ['./hotel-homepage.component.css']
})
export class HotelHomepageComponent implements OnInit {
  tod: Date;
  tom: Date;
  today: any;
  tomorrow: any;
  constructor(private hotelService: HotelService) { }

  ngOnInit() {
    this.tod = new Date();
    this.tom = new Date();
    this.tom.setDate(this.tod.getDate() + 1);
    this.today = this.tod.toISOString().split('T')[0];
    this.tomorrow = this.tom.toISOString().split('T')[0];
    
  }

  onSearchHotels() {
    
  }
}
