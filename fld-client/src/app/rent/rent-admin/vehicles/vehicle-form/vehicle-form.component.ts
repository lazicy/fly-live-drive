import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { ActivatedRoute, Params } from '@angular/router';
import { DataService } from 'src/app/services/data.service';
import { NgForm } from '@angular/forms';
import { Vehicle } from 'src/app/model/vehicle';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-vehicle-form',
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.css']
})
export class VehicleFormComponent implements OnInit {

  id: Number;
  ID: string;
  seatIdx: Number;
  public model: any;
  public seatList = [2,5,9];
  @Input() closed: Subject<boolean>;
  @Output() vehicleSubmit = new EventEmitter();

  constructor(private service: RentService, private route: ActivatedRoute, private dataService: DataService) {
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params['idF'];
      }
    ); 
   }

  ngOnInit() {
    this.closed.subscribe(
      value => {
        if(value == true){
          this.model.brand = '';
          this.model.model = '';
          this.model.number_of_seats = '';
          this.model.price_per_day = '';
          this.model.production_year = '';
          this.model.type = '';
          this.dataService.changeID(undefined);
        }
    })

    this.dataService.edit.subscribe(data => this.ID = data);
    
    //ako je pritisnut edit onda popuni model kako bi se prikazale informacije u formi
    if(this.ID!==undefined && this.ID !== ""){
      this.service.getVehicle(+this.ID).subscribe(
        (data) => {
          this.model = data;
          this.seatIdx = this.seatList.findIndex(value => value === this.model.number_of_seats);
        }
      )
    }

    

  }
  onSubmitVehicle(form: NgForm){

    var vehicle = {
      model: form.value.model,
      brand: form.value.brand,
      productionYear: form.value.production_year,
      numberOfSeats: form.value.number_of_seats,
      type: form.value.type,
      pricePerDay: form.value.price_per_day
    }

    if(this.ID !== undefined && this.ID !== ""){
      var vehicleTemp = {
          id: +this.ID,
          model: form.value.model,
          brand: form.value.brand,
          productionYear: form.value.production_year,
          numberOfSeats: form.value.number_of_seats,
          type: form.value.type,
          pricePerDay: form.value.price_per_day
        }
        this.service.editVehicle(vehicleTemp,this.id).subscribe(
          (response) => {
            this.vehicleSubmit.emit(response);
            this.ngOnDestroy();
          },
          (error) => {
            if(error.status === 403){
              swal("Error","Vehicle is reserved. You cant make any changes.","error")
            }else{
              alert(error)
            }
            
          }
          );

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
