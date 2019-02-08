import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { NgForm, FormGroup, FormControl, Validators  } from '@angular/forms';
import { ReservationHotelService } from 'src/app/services/reservation-hotel.service';

@Component({
  selector: 'app-hotel-homepage',
  templateUrl: './hotel-homepage.component.html',
  styleUrls: ['./hotel-homepage.component.css']
})
export class HotelHomepageComponent implements OnInit {
  tod: Date = new Date();
  tom: Date = new Date();
  searchHotels: FormGroup;

  hotelSearch: any;
  hotelList: any;
  showAllHotels: boolean = false;
  showSearch: boolean = false;
  emptyHotelList: boolean = false;
  notFound: boolean = false;

  danasnji = new Date();

  constructor(private hotelService: HotelService, private resHService: ReservationHotelService) {
  }

  ngOnInit() {
    this.initForm();
    this.initList();
  }

  initForm() {
    const today = this.tod.toISOString().split('T')[0];
    this.resHService.checkin = this.tod;
    this.tom.setDate(this.tod.getDate() + 1);
    this.resHService.checkout = this.tom;
    const tomorrow = this.tom.toISOString().split('T')[0];

    this.searchHotels = new FormGroup({
      'searchString': new FormControl(''),
      'checkin': new FormControl(''),
      'checkout': new FormControl(''),
      'guests': new FormControl(2)
    });

    this.searchHotels.controls['checkin'].setValue(today);
    this.searchHotels.controls['checkout'].setValue(tomorrow);
    
    this.resHService.guests = this.searchHotels.value.guests;
  }

  initList() {
    this.hotelService.getHotels()
      .subscribe(
        (data) => {
          this.hotelList = data;
          this.showAllHotels = true;
          if(this.hotelList.length === 0) {
            this.emptyHotelList = true;
          }
        },
        (error) => alert("Error: " + error)
      );
  }

  onSearchHotels(form: NgForm) {
    let ci = new Date(this.searchHotels.value.checkin);
    let co = new Date(this.searchHotels.value.checkout);
    let difer = Math.round((co.valueOf()-ci.valueOf())/(1000*60*60*24));
    if(difer > 0) {
      let searchParams = {
        search: this.searchHotels.value.searchString,
        checkin: this.searchHotels.value.checkin,
        checkout: this.searchHotels.value.checkout,
        numberOfPeople: this.searchHotels.value.guests
      }
  
      this.hotelService.searchHotel(searchParams).subscribe(
        (data) => {
          this.hotelSearch = data;
          this.resHService.checkin = ci;
          this.resHService.checkout = co;
          this.resHService.guests = this.searchHotels.value.guests;
          this.showSearch = true;
          this.showAllHotels = false;
          this.notFound = false;
          if(this.hotelSearch.length === 0) {
            this.notFound = true;
          }
        },
        (error) => alert("Error: " + error)
      );
    }
  }
    
}
