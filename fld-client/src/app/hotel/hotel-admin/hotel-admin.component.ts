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
	showAvioList: boolean = false;
  hotelList: any;
  emptyHotelList: any;

  constructor(private http: HttpClient, private hotelService: HotelService) { }

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

  onAddHotel() {
		this.showFormDialog = true;
  }
  
  onCloseForm() {
		this.showFormDialog = false;
  }
  
  hotelSubmitted(response) {
    this.hotelList.push(response);
    this.showFormDialog = false;
    this.emptyHotelList = false;
  }
  
  onDeleteHotel(id) {
		// nakon upucenog delete requesta, nema potrebe da se ponovo dobavlja lista sa servera, vec se samo taj objekat izbaci iz liste sa klijenta
		this.hotelService.deleteHotel(id).subscribe(
			(result) => {
				// fensi for petlja
				let i = this.hotelList.findIndex(avio => avio.id === id);
				// obrisi jednog clana na poziciji i
        this.hotelList.splice(i, 1);
        if(this.hotelList.length === 0) {
          this.emptyHotelList = true;
        }

			}, (error) => alert("Error occured")
		);
	}

}
