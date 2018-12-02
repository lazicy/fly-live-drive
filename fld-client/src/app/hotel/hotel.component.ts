import { Component, OnInit } from '@angular/core';
import { HotelService } from '../services/hotel.service';

@Component({
  selector: 'app-hotel',
  templateUrl: './hotel.component.html',
  styleUrls: ['./hotel.component.css']
})
export class HotelComponent implements OnInit {
  today: any;
  constructor(private hotelService: HotelService) { }

  ngOnInit() {
    this.today = new Date().toISOString().split('T')[0];
    
  }

  onSearchHotels() {
    
  }

}
