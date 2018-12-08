import { Component, OnInit } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { SafeStyle } from '@angular/platform-browser';

@Component({
  selector: 'app-hotel-page',
  templateUrl: './hotel-page.component.html',
  styleUrls: ['./hotel-page.component.css']
})
export class HotelPageComponent implements OnInit {
  hotel: any;
  id: number;

  constructor(private hotelService: HotelService, private route: ActivatedRoute, private router: Router) {
    this.route.params.subscribe(
        (params: Params) => {
          this.id = +params['id'];
        }
      );

    if(this.id !== NaN && this.id !== undefined) {
      this.hotelService.getHotel(this.id).subscribe(
          (data) => {this.hotel = data;},
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
}
