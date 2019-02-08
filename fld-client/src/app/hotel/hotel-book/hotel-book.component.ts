import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { HttpClient } from '@angular/common/http';
import { HotelService } from 'src/app/services/hotel.service';
import { ReservationHotelService } from 'src/app/services/reservation-hotel.service';
import { AuthService } from 'src/app/services/auth.service';

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
  popust: any = 0;
  broj_ljudi: any = 0;
  chkI: any;
  chkO: any;
  br_dana: any = 0;
  username: any;

  constructor(private route: ActivatedRoute, private authService: AuthService,private router: Router, private hotelService: HotelService, private resHService: ReservationHotelService) {
    
    this.route.params.subscribe(
			(params: Params) => {
        this.hotelID = +params['idh']
				this.id = +params['rid'];
			}
    );

    this.broj_ljudi = this.resHService.guests;
    this.chkI = this.resHService.checkin;
    this.chkO = this.resHService.checkout;
    this.br_dana = Math.round((this.chkO.valueOf()-this.chkI.valueOf())/(1000*60*60*24));

    this.hotelService.getHotelRoom(this.id).subscribe(
      data => {
        this.room = data;
        this.cenaSobe = this.room.price * this.br_dana;
        this.cenaTotal = this.room.price * this.br_dana;
        this.fetchServices();
      },  
      error => console.log(error)
    );

    this.authService.getUser().subscribe(
      (data) => {
        this.username = data;
      },
      (error) => console.log(error)
    );
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
      
      this.selektovaneUsluge.push(ser);
      if(ser.charge === "Person") {
        this.cenaUsluga += ser.price * this.broj_ljudi;
        this.cenaTotal += ser.price * this.broj_ljudi - this.cenaSobe*(ser.discount/100.00);
      } else if (ser.charge === "Day") {
        this.cenaUsluga += ser.price * this.br_dana;
        this.cenaTotal += ser.price*this.br_dana - this.cenaSobe*(ser.discount/100.00);
      } else {
        this.cenaUsluga += ser.price;
        this.cenaTotal += ser.price - this.cenaSobe*(ser.discount/100.00);
      }
      this.popust += ser.discount;
    } else {
      let i = this.selektovaneUsluge.findIndex(usluga => usluga.id === ser.id);
      this.selektovaneUsluge.splice(i, 1);
      if(ser.charge === "Person") {
        this.cenaUsluga -= ser.price * this.broj_ljudi;
        this.cenaTotal -= ser.price * this.broj_ljudi - this.cenaSobe*(ser.discount/100.00);
      } else if (ser.charge === "Day") {
        this.cenaUsluga -= ser.price * this.br_dana;
        this.cenaTotal -= ser.price*this.br_dana - this.cenaSobe*(ser.discount/100.00);
      } else {
        this.cenaUsluga -= ser.price;
        this.cenaTotal -= ser.price - this.cenaSobe*(ser.discount/100.00);
      }
      this.popust -= ser.discount;
    }
  }

  onFinishRes() {
    const res_date = new Date();
    let hotelrez = {
	  reservation_date: res_date,
	  arrival_date: this.chkI,
	  departure_date: this.chkO,
	  no_nights: this.br_dana,
	  discount: 0,
	  total_price: this.cenaTotal,
	  fastRez: false
    }

    this.resHService.saveHotelReservation(this.room.id, this.username, hotelrez).subscribe(
      (data) => {
        this.addServicesToRes(data);
      },
      (error) => {
        if (error.status === 409) {
          swal ( "Cannot do that" ,  "Unfortunately some has already booked the room." ,  "warning" );
        } else {
          swal ( "Error occured" ,  "Reservation has not been made." ,  "error" );
        }
         
      }
    );
  }

  addServicesToRes(res) {
    this.resHService.saveHotelReservationServices(res.id, this.selektovaneUsluge).subscribe(
      (data) => {
        let pom = data;
        swal({title: "Congratulations!", text: "Your room has been booked", icon: "success", timer: 1800});
        this.router.navigate(['/home']);
      },
      (error) => {
        swal ( "Error occured" ,  "Your room was not booked." ,  "error" );
      }
    );
  }

    onFinishContinue() {
      const res_date = new Date();
      let hotelrez = {
	      reservation_date: res_date,
	      arrival_date: this.chkI,
	      departure_date: this.chkO,
	      no_nights: this.br_dana,
	      discount: 0,
	      total_price: this.cenaTotal,
	      fastRez: false
      }
      this.resHService.saveHotelReservation(this.room.id, this.username, hotelrez).subscribe(
        (data) => {
          this.addServicesToResANDCONTINUE(data);
        },
        (error) => {
          if (error.status === 409) {
          swal ( "Cannot do that" ,  "Unfortunately some has already booked the room." ,  "warning" );
          } else {
            swal ( "Error occured" ,  "Reservation has not been made." ,  "error" );
        }
       }
      );
    }

    addServicesToResANDCONTINUE(res) {
      this.resHService.saveHotelReservationServices(res.id, this.selektovaneUsluge).subscribe(
        (data) => {
          let pom = data;
          swal({title: "Congratulations!", text: "Your room has been booked", icon: "success", timer: 1800});
          this.router.navigate(['/rent']);
        },
        (error) => {
          swal ( "Error occured" ,  "Your room was not booked." ,  "error" );
        }
      );
    }
}
