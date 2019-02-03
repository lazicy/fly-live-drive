import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HotelService } from 'src/app/services/hotel.service';

@Component({
  selector: 'app-hotel-admin',
  templateUrl: './hotel-admin.component.html',
  styleUrls: ['./hotel-admin.component.css']
})
export class HotelAdminComponent implements OnInit {
  showFormDialog: boolean = false;
  hotelList: any;
  emptyHotelList: any;

  constructor(private http: HttpClient, private hotelService: HotelService) { }

  ngOnInit() {
  }
}
