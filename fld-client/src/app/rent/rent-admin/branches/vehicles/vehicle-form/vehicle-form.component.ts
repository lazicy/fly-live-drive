import { Component, OnInit, Output, EventEmitter, Input } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { ActivatedRoute, Params } from '@angular/router';
import { DataService } from 'src/app/services/data.service';
import { NgForm } from '@angular/forms';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-vehicle-form',
  templateUrl: './vehicle-form.component.html',
  styleUrls: ['./vehicle-form.component.css']
})
export class VehicleFormComponent implements OnInit {

  id: number;
  ID: string;
  vehicle: any = null;


  //two-way binding atributi
  model: string = '';
  brand: string = '';
  production_year: string = '';
  number_of_seats: number = 0;
  type: string = '';
  price_per_day: string = '';
  seatList = [2,5,9];
  
  @Output() vehicleSubmit = new EventEmitter();
  @Input() closed: Subject<boolean>;

  constructor(private service: RentService, private route: ActivatedRoute, private dataService: DataService) {
    this.route.params.subscribe(
      (params: Params) => {
        this.id = +params['idF'];
      }
    ); 
   }

  ngOnInit() {
    this.dataService.edit.subscribe(data => this.ID = data);
    
    //dodati za close
    this.closed.subscribe(
      value=>{
        if(value == true){
          this.vehicle = null;
          this.dataService.changeID(undefined);
        }
      }
    )

    if(this.ID!==undefined && this.ID !== ""){
      this.service.getVehicle(+this.ID).subscribe(
        (data) => {
          this.vehicle = data;
          this.fillForm();
        }
      )
    }
  }
  onSubmitVehicle(form: NgForm){
    var vehicle = {
      model: this.model,
      brand: this.brand,
      productionYear: this.production_year,
      numberOfSeats: this.number_of_seats,
      type: this.type,
      pricePerDay: this.price_per_day
    }
    if(this.ID !== undefined && this.ID !== ""){
      var vehicleTemp = {
          id: +this.ID,
          model: this.model,
          brand: this.brand,
          productionYear: this.production_year,
          numberOfSeats: this.number_of_seats,
          type: this.type,
          pricePerDay: this.price_per_day
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

  fillForm(){
    this.model = this.vehicle.model;
    this.brand = this.vehicle.brand;
    this.production_year = this.vehicle.productionYear;
    this.number_of_seats = this.vehicle.numberOfSeats;
    this.type = this.vehicle.type;
    this.price_per_day = this.vehicle.pricePerDay;
  }

  onReset(form: NgForm){
    form.reset();
  }
  ngOnDestroy(){
    this.vehicleSubmit.unsubscribe();
  }
}
