import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { ActivatedRoute, Params } from '@angular/router';
import { DataService } from 'src/app/services/data.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-vehicle-form',
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.css']
})
export class VehicleFormComponent implements OnInit {

  id: number;
  ID: string;
  @Output() vehicleSubmit = new EventEmitter();

  constructor(private service: RentService, private route: ActivatedRoute, private dataService: DataService) {
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params['idF'];
      }
    ); 
   }

  ngOnInit() {
    this.dataService.edit.subscribe(data => this.ID = data);
  }

  onSubmitVehicle(form: NgForm){

    var vehicle = {
      model: form.value.model,
      brand: form.value.brand,
      productionYear: form.value.production_year,
      numberOfSeats: form.value.number_of_seats,
      type: form.value.type
    }

    if(this.ID !== undefined && this.ID !== ""){
        var vehicleTemp = {
          id: +this.ID,
          model: form.value.model,
          brand: form.value.brand,
          productionYear: form.value.production_year,
          numberOfSeats: form.value.number_of_seats,
          type: form.value.type
        }
        this.service.editVehicle(vehicleTemp,this.id).subscribe(
          (response) => {
            this.vehicleSubmit.emit(response);
            this.ngOnDestroy();
          },
          (error) => alert(error)
        )

    }else{
      this.service.addVehicle(vehicle,this.id).subscribe(
        (response) => {
          this.vehicleSubmit.emit(response);
          
        },
        (error) => alert(error.message)
      )
    }

    form.reset();
  }

  onReset(form: NgForm){
    form.reset();
  }
  ngOnDestroy(){
    this.vehicleSubmit.unsubscribe();
  }
}
