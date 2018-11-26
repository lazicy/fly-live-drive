import { Component, OnInit, OnDestroy } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';

@Component({
  selector: 'app-hotel-list',
  templateUrl: './hotel-list.component.html',
  styleUrls: ['./hotel-list.component.css']
})
export class HotelListComponent implements OnInit, OnDestroy {
  hotelList: any;
  emptyHotelList: boolean = false;
  constructor(private hotelService: HotelService) { }

  ngOnInit() {
    this.hotelService.getHotels()
      .subscribe(
        (data) => {
          this.hotelList = data;
          if(this.hotelList.length === 0) {
            this.emptyHotelList = true;
          }
        },
        (error) => alert("Error: " + error)
      );
  }

  ngOnDestroy() {
    //TODO
  }
}
