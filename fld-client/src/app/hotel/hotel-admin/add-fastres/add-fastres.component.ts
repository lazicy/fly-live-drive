import { Component, OnInit, OnDestroy, EventEmitter, Output, Input } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
@Component({
  selector: 'app-add-fastres',
  templateUrl: './add-fastres.component.html',
  styleUrls: ['./add-fastres.component.css']
})
export class AddFastresComponent implements OnInit {

  @Output() fastSubmit = new EventEmitter();

  @Input() hotelId: number;
  sobe: any = null;
  usluge: any = null;

  tod: Date = new Date();
  tom: Date = new Date();
  danas: any;
  sutra: any;
  selektovaneUsluge: any = [];

  constructor(private hotelService: HotelService, private router: Router) { }

  ngOnInit() {
    this.danas = this.tod.toISOString().split('T')[0];
    this.tom.setDate(this.tod.getDate() + 1);
    this.sutra = this.tom.toISOString().split('T')[0];

    this.hotelService.getHotelRooms(this.hotelId).subscribe(
      data => {
        this.sobe = data;
      },  
      error => alert(error)
    );
    this.hotelService.getHotelServices(this.hotelId).subscribe(
      data => {
        this.usluge = data;
      },  
      error => alert(error)
    );
  }

  ngOnDestroy() {
		this.fastSubmit.unsubscribe();
  }

  onSubmitRoom(form: NgForm) {
      let fastRoom = {
        start_date: form.value.start,
        end_date: form.value.end,
        discount: form.value.discount
      }

      this.hotelService.saveFastRez(fastRoom, form.value.room).subscribe(

      );
  
      // this.hotelService.saveHotelRoom(fastRoom, this.selektovaneUsluge, this.hotelId).subscribe(
      //   (response) => {
      //     this.roomSubmit.emit(response);
      //     swal({title: "Success!", text: "Room added", icon: "success", timer: 1500});
      //     form.reset();
      //     this.ngOnDestroy();
      //   },
      //   (error) => {swal ( "Error occured" ,  "The room was not added." ,  "error" );}
      // );
  }

  serviceIsSelected(e, ser) {
    let selecte = e.target.checked;
    if(selecte) {
      this.selektovaneUsluge.push(ser);
      
    } else {
      let i = this.selektovaneUsluge.findIndex(usluga => usluga.id === ser.id);
      this.selektovaneUsluge.splice(i, 1);
    }
  }

  onKeydown(e) {
    if(!((e.keyCode > 95 && e.keyCode < 106)
      || (e.keyCode > 47 && e.keyCode < 58) 
      || e.keyCode == 8)) {
        return false;
    }
  }

}
