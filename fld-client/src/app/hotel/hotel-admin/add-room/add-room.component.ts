import { Component, OnInit, OnDestroy, EventEmitter, Output, Input } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-room',
  templateUrl: './add-room.component.html',
  styleUrls: ['./add-room.component.css']
})
export class AddRoomComponent implements OnInit {
  @Output() roomSubmit = new EventEmitter();

  @Input() hotelId: number;

  niz_spratova: any = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
  showErrorMsg: boolean = false;

  constructor(private hotelService: HotelService, private router: Router) { }

  ngOnInit() {
  }

  ngOnDestroy() {
		this.roomSubmit.unsubscribe();
  }

  onSubmitRoom(form: NgForm) {
    let razlika = form.value.people - form.value.beds;
    if(razlika <= 2 && razlika >= 0) {
      this.showErrorMsg = false;
      let room = {
        name: form.value.name,
        beds: form.value.beds,
        people_capacity: form.value.people,
        price: form.value.price,
        floor: form.value.floor,
        balcony: form.value.balcony
      }
  
      this.hotelService.saveHotelRoom(room, this.hotelId).subscribe(
        (response) => {
          this.roomSubmit.emit(response);
          swal({title: "Success!", text: "Room added", icon: "success", timer: 1500});
          form.reset();
          this.ngOnDestroy();
        },
        (error) => {swal ( "Error occured" ,  "The room was not added." ,  "error" );}
      );
    } else {
      this.showErrorMsg = true;
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
