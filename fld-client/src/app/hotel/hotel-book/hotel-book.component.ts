import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { HotelService } from 'src/app/services/hotel.service';
import { ReservationHotelService } from 'src/app/services/reservation-hotel.service';

@Component({
  selector: 'app-hotel-book',
  templateUrl: './hotel-book.component.html',
  styleUrls: ['./hotel-book.component.css']
})
export class HotelBookComponent implements OnInit {

  id: number;
  hotelID: number;
  room: any = null;
  usluge: any = null;
  selektovaneUsluge: any = [];
  cenaSobe: any = 0;
  cenaUsluga: any = 0;
  cenaTotal: any = 0;
  broj_ljudi: any = 0;
  chkI: any;
  chkO: any;

  constructor(private route: ActivatedRoute, private router: Router, private hotelService: HotelService, private resHService: ReservationHotelService) {
    
    this.route.params.subscribe(
			(params: Params) => {
        this.hotelID = +params['idh']
				this.id = +params['rid'];
			}
    );

    this.hotelService.getHotelRoom(this.id).subscribe(
      data => {
        this.room = data;
        this.cenaSobe = this.room.price;
        this.cenaTotal = this.room.price;
        this.fetchServices();
      },  
      error => console.log(error)
    );

    this.broj_ljudi = resHService.guests;
    this.chkI = resHService.checkin;
    this.chkO = resHService.checkout;
  }

  ngOnInit() {
    
  }

  fetchServices() {
    this.hotelService.getHotelServices(this.hotelID).subscribe(
      data => {
        this.usluge = data;
      },  
      error => console.log(error)
        
    );
  }

  serviceIsSelected(e, ser) {
    let selecte = e.target.checked;
    if(selecte) {
      if(ser.charge === "People") {
        ser.price = ser.price * this.broj_ljudi;
      } else if (ser.charge === "Day") {
        var diff = this.chkO.valueOf() - this.chkI.valueOf();
        ser.price = ser.price * diff;
      }
      this.selektovaneUsluge.push(ser);
      this.cenaUsluga += ser.price;
      let sPop = ser.price - this.cenaTotal*(ser.discount/100.00);
      this.cenaTotal += Math.round(+sPop);
      
    } else {
      let i = this.selektovaneUsluge.findIndex(usluga => usluga.id === ser.id);
      this.selektovaneUsluge.splice(i, 1);
      this.cenaUsluga -= ser.price;
      let sPop = ser.price - this.cenaTotal*(ser.discount/100.00);
      this.cenaTotal -= Math.round(+sPop);
    }
  }

  onFinishRes() {
    const tod = new Date();
    const reservation_date = tod.toISOString().split('T')[0];


  }
}
