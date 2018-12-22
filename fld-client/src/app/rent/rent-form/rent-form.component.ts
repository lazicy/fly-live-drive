import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RentService } from 'src/app/services/rentacar.service';

@Component({
  selector: 'app-rent-form',
  templateUrl: './rent-form.component.html',
  styleUrls: ['./rent-form.component.css']
})
export class RentFormComponent implements OnInit {

  @Output() rentSubmit = new EventEmitter(); //???

  constructor(private service: RentService) { }

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
        // emituje se event koji se slusa u selektoru ove komponente (child) u okviru html-a parent komponente (ovde se salje
				// response a tamo se prima $event). 
        this.rentSubmit.emit(response);
        this.ngOnDestroy();
      },
      (error) => {
        swal("Error", "error");
      }
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
