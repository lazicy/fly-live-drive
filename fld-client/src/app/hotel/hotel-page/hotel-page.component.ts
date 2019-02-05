import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SafeStyle, DomSanitizer } from '@angular/platform-browser';

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

  constructor(private hotelService: HotelService, private route: ActivatedRoute, private router: Router, public sanitizer: DomSanitizer) {
    this.route.params.subscribe(
        (params: Params) => {
          this.id = +params['id'];
        }
      );

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

  ngOnInit() {
    
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
    // this.hotelService.getHotelRooms(this.id).subscribe(
    //   data => {
    //     this.hotel.rooms = data;
    //     if(this.hotel.rooms.length === 0) {
    //       this.emptyRoomList = true;
    //     }
    //   },  
    //   error => console.log(error)
        
    // );
  }

  onShowMore() {
    this.hideServ = !this.hideServ;
    if(this.ShowText == "Show more") {
      this.ShowText = "Show less"
    } else {
      this.ShowText = "Show more"
    }
  }
}
