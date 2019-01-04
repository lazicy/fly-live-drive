import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { RentService } from 'src/app/services/rentacar.service';
import { DataService } from 'src/app/services/data.service';
import { RentACar } from 'src/app/model/rentacar';
import { NumberValueAccessor } from '@angular/forms/src/directives';

@Component({
  selector: 'app-rent-form',
  templateUrl: './rent-form.component.html',
  styleUrls: ['./rent-form.component.css']
})
export class RentFormComponent implements OnInit {

  @Output() rentSubmit = new EventEmitter(); //???
  ID : string;
  constructor(private service: RentService, private dataService: DataService) { }

  ngOnInit() {
    this.dataService.edit.subscribe(data => this.ID = data); //subscribe na edit (cuva info da li se radi edit ili ne)
  }

  onSubmitRent(form: NgForm){
    var rent = {
      name: form.value.name,
      address: form.value.adress,
      city: form.value.city,
      country: form.value.country,
      description: form.value.description
    }

    //ako ima id znaci da se radi edit pa se mora proslediti i id rentacar-a
    //kako bi na serveru uradio promenu a ne dodavanje novog rentacar-a
    if(this.ID !== undefined){
        var rentTemp = {
          id: +this.ID,
          name: form.value.name,
          address: form.value.adress,
          city: form.value.city,
          country: form.value.country,
          description: form.value.description
      }

      this.service.editRent(rentTemp).subscribe(
        (response) => {
          //swal();
          this.rentSubmit.emit(response);
          this.ngOnDestroy();
        },
        (error) => {alert(error); return;} 
      )

    }else{
      
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
    }
    
    form.reset();
  }

  onReset(form: NgForm){
    form.reset();
  }

  ngOnDestroy(){
    this.rentSubmit.unsubscribe();
  }

}
