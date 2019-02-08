import { Component, OnInit, OnDestroy, EventEmitter, Output, Input  } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { Router } from '@angular/router';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-room',
  templateUrl: './edit-room.component.html',
  styleUrls: ['./edit-room.component.css']
})
export class EditRoomComponent implements OnInit {

  @Output() roomUpdate = new EventEmitter();

  @Input('hotelId') hotelId: number;
  @Input('roomId') roomId: number;

  room: any = null;
  roomForm: FormGroup;

  niz_spratova: any = [1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30]
  showErrorMsg: boolean = false;

  constructor(private hotelService: HotelService, private router: Router) { }

  ngOnInit() {
    if (this.roomId !== NaN && this.roomId !== undefined) {
			this.hotelService.getHotelRoom(this.roomId).subscribe(
				(data) => {
          this.room = data;
          this.initForm();
				},
				(error) => {
					console.log(error);
					if (error.status === 404) {
						this.router.navigate(['hotel']);
					} else {
						console.error(error);
					}
				}
      );
    }
  }

  initForm() {
    this.roomForm = new FormGroup({
      'name': new FormControl(this.room.name, Validators.required),
      'balcony': new FormControl(this.room.balcony),
      'beds': new FormControl(this.room.beds),
      'people': new FormControl(this.room.people_capacity),
      'floor': new FormControl(this.room.floor),
      'price': new FormControl(this.room.price)
    });
  }

  ngOnDestroy() {
		this.roomUpdate.unsubscribe();
  }

  onSubmitRoom() {

    let razlika = this.roomForm.value.people - this.roomForm.value.beds;
    if(razlika <= 2 && razlika >= 0) {
      this.showErrorMsg = false;
      let room = {
        id: this.roomId,
        name: this.roomForm.value.name,
        beds: this.roomForm.value.beds,
        people_capacity: this.roomForm.value.people,
        price: this.roomForm.value.price,
        floor: this.roomForm.value.floor,
        balcony: this.roomForm.value.balcony,
        rating: this.room.rating
      }

      this.hotelService.updateHotelRoom(room, this.hotelId).subscribe(
        (response) => {
          this.roomUpdate.emit(response);
          swal({title: "Success!", text: "Room updated", icon: "success", timer: 1500});
          this.ngOnDestroy();
        },
        (error) => {
          if (error.status === 409) {
            swal ( "Cannot do that" ,  "There is a reservation of that room." ,  "warning" );
          } else {
            console.error(error);
            swal ( "Error occured" ,  "The room was not updated." ,  "error" );
          }
          
        }
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

  get name() { return this.roomForm.get('name'); }

}
