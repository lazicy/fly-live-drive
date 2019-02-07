import { Component, OnInit, OnDestroy, EventEmitter, Output, Input } from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { Router } from '@angular/router';
import { NgForm, FormGroup, FormControl, Validators } from '@angular/forms';

@Component({
  selector: 'app-edit-service',
  templateUrl: './edit-service.component.html',
  styleUrls: ['./edit-service.component.css']
})

export class EditServiceComponent implements OnInit {

  @Output() serviceUpdate = new EventEmitter();

  @Input('hotelId') hotelId: number;
  @Input('servic') servic: number;

  usluga: any = null;
  idH: number;
  serviceForm: FormGroup;

  constructor(private hotelService: HotelService, private router: Router) { }

  ngOnInit() {
    this.idH = +this.hotelId;
    if (this.servic !== NaN && this.servic !== undefined) {
			this.hotelService.getHotelService(this.servic).subscribe(
				(data) => {
          this.usluga = data;
          this.initUslForm();
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

  initUslForm() {
    this.serviceForm = new FormGroup({
      'name': new FormControl(this.usluga.name, Validators.required),
      'price': new FormControl(this.usluga.price),
      'charge': new FormControl(this.usluga.charge),
      'discount': new FormControl(this.usluga.discount)
    });
  }

  ngOnDestroy() {
		this.serviceUpdate.unsubscribe();
  }

  onSubmitService() {

    let servc = {
      id: this.servic,
      name: this.serviceForm.value.name,
      price: this.serviceForm.value.price,
      charge: this.serviceForm.value.charge,
      discount: this.serviceForm.value.discount
    }

    this.hotelService.updateHotelService(servc, this.idH).subscribe(
      (response) => {
        this.serviceUpdate.emit(response);
        swal({title: "Success!", text: "Service updated", icon: "success", timer: 1500});
        this.ngOnDestroy();
      },
      (error) => {swal ( "Error occured" ,  "The service was not updated." ,  "error" );}
    );
  }

  onKeydown(e) {
    if(!((e.keyCode > 95 && e.keyCode < 106)
      || (e.keyCode > 47 && e.keyCode < 58) 
      || e.keyCode == 8)) {
        return false;
    }
  }

  get name() { return this.serviceForm.get('name'); }

}
