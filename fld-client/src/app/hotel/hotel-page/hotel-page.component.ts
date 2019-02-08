import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SafeStyle, DomSanitizer } from '@angular/platform-browser';
import { ReservationHotelService } from 'src/app/services/reservation-hotel.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-hotel-page',
  templateUrl: './hotel-page.component.html',
  styleUrls: ['./hotel-page.component.css']
})
export class HotelPageComponent implements OnInit {
  hotel: any = null;
  id: number;
  map: boolean = false;
  slika: any = null;
  emptyServicesList: boolean = false;
  emptyRoomList: boolean = false;
  hideServ: boolean = true;
  ShowText: any = "Show more";
  currentStyles = {     
    
  };
  CIdate: Date;
  COdate: Date;
  gosti: number;
  broj_dana: number;

  jesteKorisnik: boolean = false;
  jesteAdmin: boolean = false;
  rola: any;
  fastRes: any = null;
  prikaziBrze: boolean = false;

  constructor(private hotelService: HotelService, private route: ActivatedRoute, private userService: UserService, private router: Router, public sanitizer: DomSanitizer, private resHService: ReservationHotelService) {
    this.route.params.subscribe(
        (params: Params) => {
          this.id = +params['id'];
        }
    );

    this.CIdate = this.resHService.checkin;
    this.COdate = this.resHService.checkout;
    this.gosti = this.resHService.guests;
    this.broj_dana =  Math.round((this.COdate.valueOf()-this.CIdate.valueOf())/(1000*60*60*24));
  }

  ngOnInit() {
    if(this.id !== NaN && this.id !== undefined) {
      this.hotelService.getHotel(this.id).subscribe(
          (data) => {
            this.hotel = data;
            this.slika = this.hotel.hotelImageURL;
            this.currentStyles = {
              'background-image':  "url('" + this.slika + "')"
            }
            if(this.hotel.map === "") {
                this.map = true;
            }
            this.fetchServices();
            this.fetchRooms();
            this.funkcije();
            this.fetchFast();
          },
          (error) => {
            alert(error);
            if (error.status === 404) {
              this.router.navigate(['hotel']);
            } else {
              console.error(error);
            }
          }
      );
    }
  }

  fetchFast() {
    let src = {
      search: "",
      checkin: this.CIdate,
      checkout: this.COdate,
      numberOfPeople: 0
    }
    this.hotelService.getRoomOnFast(this.hotel.id, src).subscribe(
      (data) => {
        this.fastRes = data;
      }, (error) => {
        alert(error);
      }
    );
  }

  funkcije() {
    this.userService.getUserRole().subscribe(
      (data) => {
        this.rola = data;
        if(this.rola === "HOTEL_ADMIN") {
          this.jesteAdmin = true;
        } else if (this.rola === "User") {
          this.jesteKorisnik = true;
        } else {
          //just in case
          this.jesteAdmin = false;
          this.jesteKorisnik = false;
        }
      },
      (error) => console.log(error)

    );
  }

  fetchServices() {
    this.hotelService.getHotelServices(this.id).subscribe(
      data => {
        this.hotel.services = data;
        if(this.hotel.services.length === 0) {
          this.emptyServicesList = true;
        }
      },  
      error => console.log(error)
        
    );
  }

  fetchRooms() {

    let podaci = {
      search: "",
      checkin: this.CIdate,
      checkout: this.COdate,
      numberOfPeople: this.gosti
    }

    this.hotelService.getFreeRooms(this.hotel.id, podaci).subscribe(
      (data) => {
        this.hotel.rooms = data;
        if(this.hotel.rooms.length === 0) {
          this.emptyRoomList = true;
        }
      },  
      error => console.log(error)
    );
  }

  onShowMore() {
    this.hideServ = !this.hideServ;
    if(this.ShowText == "Show more") {
      this.ShowText = "Show less"
    } else {
      this.ShowText = "Show more"
    }
  }

  onBookRoom(rid) {
    this.router.navigate(['hotel/' + this.id + '/book/' + rid]);
  }

  onBookFastRoom(rid) {

  }
}
