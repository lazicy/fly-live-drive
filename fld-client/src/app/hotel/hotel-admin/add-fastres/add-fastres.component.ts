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
    // let razlika = form.value.end - form.value.start;
    // if(razlika <= 2 && razlika >= 0) {
    //   this.showErrorMsg = false;
    //   let room = {
    //     name: form.value.name,
    //     beds: form.value.beds,
    //     people_capacity: form.value.people,
    //     price: form.value.price,
    //     floor: form.value.floor,
    //     balcony: form.value.balcony
    //   }
  
    //   this.hotelService.saveHotelRoom(room, this.hotelId).subscribe(
    //     (response) => {
    //       this.roomSubmit.emit(response);
    //       swal({title: "Success!", text: "Room added", icon: "success", timer: 1500});
    //       form.reset();
    //       this.ngOnDestroy();
    //     },
    //     (error) => {swal ( "Error occured" ,  "The room was not added." ,  "error" );}
    //   );
    // } else {
    //   this.showErrorMsg = true;
    // }
  }

  onKeydown(e) {
    if(!((e.keyCode > 95 && e.keyCode < 106)
      || (e.keyCode > 47 && e.keyCode < 58) 
      || e.keyCode == 8)) {
        return false;
    }
  }

}
