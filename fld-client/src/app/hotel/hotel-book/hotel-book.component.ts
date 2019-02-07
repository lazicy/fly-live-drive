import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { HotelService } from 'src/app/services/hotel.service';

@Component({
  selector: 'app-hotel-book',
  templateUrl: './hotel-book.component.html',
  styleUrls: ['./hotel-book.component.css']
})
export class HotelBookComponent implements OnInit {

  id: number;
  rooms: any = null;
  usluge: any = null;
  roomsSelected: boolean = false;
  selektovaneSobe: any = [];
  selektovaneUsluge: any = [];
  noRoomsSelected: boolean = false;
  prikaziSobe: boolean = true;
  prikaziUsluge: boolean = false;
  cenaSoba: any = 0;
  cenaUsluga: any = 0;
  cenaTotal: any = 0;

  constructor(private route: ActivatedRoute, private router: Router, private hotelService: HotelService) {
    
    this.route.params.subscribe(
			(params: Params) => {
				this.id = +params['idB'];
			}
    );

    this.hotelService.getHotelRooms(this.id).subscribe(
      data => {
        this.rooms = data;
      },  
      error => console.log(error)
    );
  }

  ngOnInit() {
  }

  roomIsSelected(e, room) {
    let selected = e.target.checked;
    if(selected) {
      this.selektovaneSobe.push(room);
    } else {
      let i = this.selektovaneSobe.findIndex(soba => soba.id === room.id);
      this.selektovaneSobe.splice(i, 1);
    }
  }

  onNextRoom() {
    if(this.selektovaneSobe.length !== 0) {
      this.noRoomsSelected = false;
      this.prikaziSobe = false;
      this.prikaziUsluge = true;
      for(let sobe of this.selektovaneSobe) {
        this.cenaSoba += sobe.price;
      }
      this.cenaTotal = this.cenaSoba;
      this.fetchServices();
    } else {
      this.noRoomsSelected = true;
    }
  }

  fetchServices() {
    this.hotelService.getHotelServices(this.id).subscribe(
      data => {
        this.usluge = data;
      },  
      error => console.log(error)
        
    );
  }

  onBack() {
    this.prikaziSobe = true;
    this.prikaziUsluge = false;
  }

  serviceIsSelected(e, ser) {
    let selecte = e.target.checked;
    if(selecte) {
      this.selektovaneUsluge.push(ser);
      this.cenaUsluga += ser.price;
      this.cenaTotal += ser.price;
    } else {
      let i = this.selektovaneUsluge.findIndex(usluga => usluga.id === ser.id);
      this.selektovaneUsluge.splice(i, 1);
      this.cenaUsluga -= ser.price;
      this.cenaTotal -= ser.price;
    }
  }

}
