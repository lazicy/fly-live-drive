import { Component, OnInit, Output, EventEmitter, OnDestroy } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { RentService } from 'src/app/services/rentacar.service';

@Component({
  selector: 'app-sys-car-form',
  templateUrl: './sys-car-form.component.html',
  styleUrls: ['./sys-car-form.component.css']
})
export class SysCarFormComponent implements OnInit, OnDestroy {

  @Output() rentSubmit = new EventEmitter();

  constructor(private http: HttpClient, private service: RentService) { }

  ngOnInit() {
  }

  onSubmitRent(form: NgForm){

    let rent = {
      name: form.value.name,
      adress: form.value.adress,
      city: form.value.city,
      country: form.value.country,
      description: form.value.description
    }

    this.service.saveRent(rent).subscribe(
      (response) => {
        this.rentSubmit.emit(response);
        swal({title: "Success!", text: "Rent-A-Car company added", icon: "success", timer: 1500});
        this.ngOnDestroy();
      },
      (error) => {swal ( "Error occured" ,  "The company was not added." ,  "error" );}
    )

    form.reset();
  }

  onReset(form: NgForm){
    form.reset();
  }

  ngOnDestroy(){
    this.rentSubmit.unsubscribe();
  }
}
