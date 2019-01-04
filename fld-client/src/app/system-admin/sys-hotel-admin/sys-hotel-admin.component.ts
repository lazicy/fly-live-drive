import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { HotelService } from 'src/app/services/hotel.service';

@Component({
  selector: 'app-sys-hotel-admin',
  templateUrl: './sys-hotel-admin.component.html',
  styleUrls: ['./sys-hotel-admin.component.css']
})
export class SysHotelAdminComponent implements OnInit {

  showFormDialog: boolean = false;
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

  onEditHotel(id) {
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

    swal({
      title: "Are you sure?",
      icon: "warning",
      buttons: ["Cancel", "Delete"],
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
        this.hotelService.deleteHotel(id).subscribe(
          (result) => {
              // fensi for petlja
              let i = this.hotelList.findIndex(hotel => hotel.id === id);
              // obrisi jednog clana na poziciji i
              this.hotelList.splice(i, 1);
              swal({title: "Success!", text: "Hotel deleted.", icon: "success", timer: 1500});
              if(this.hotelList.length === 0) {
                this.emptyHotelList = true;
              }
          }, (error) =>  {swal ( "Error occured" ,  "The hotel was not deleted." ,  "error" );}
          );
      }
    });
	}
}
