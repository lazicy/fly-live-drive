import { Component, OnInit, OnDestroy, EventEmitter, Output, Input} from '@angular/core';
import { HotelService } from 'src/app/services/hotel.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';

@Component({
  selector: 'app-add-service',
  templateUrl: './add-service.component.html',
  styleUrls: ['./add-service.component.css']
})
export class AddServiceComponent implements OnInit {
  @Output() serviceSubmit = new EventEmitter();

  @Input() hotelId: number;

  constructor(private hotelService: HotelService, private router: Router) { }

  ngOnInit() {
  }

  ngOnDestroy() {
		this.serviceSubmit.unsubscribe();
  }
  
  onSubmitService(form: NgForm) {

    let servc = {
      name: form.value.name,
      price: form.value.price,
      charge: form.value.charge
    }

    this.hotelService.saveHotelService(servc, this.hotelId).subscribe(
      (response) => {
        this.serviceSubmit.emit(response);
        swal({title: "Success!", text: "Service added", icon: "success", timer: 1500});
        form.reset();
        this.ngOnDestroy();
      },
      (error) => {swal ( "Error occured" ,  "The service was not added." ,  "error" );}
    );
  }

  onKeydown(e) {
    if(!((e.keyCode > 95 && e.keyCode < 106)
      || (e.keyCode > 47 && e.keyCode < 58) 
      || e.keyCode == 8)) {
        return false;
    }
  }

}
