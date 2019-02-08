import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Params } from '@angular/router';
import { FastVehicleService } from 'src/app/services/fastvehicle.service';
import { RentService } from 'src/app/services/rentacar.service';
import { DatePipe } from '@angular/common';
import { FormGroup, FormControl } from '@angular/forms';

@Component({
  selector: 'app-fast-res-vehicle',
  templateUrl: './fast-res-vehicle.component.html',
  styleUrls: ['./fast-res-vehicle.component.css']
})
export class FastResVehicleComponent implements OnInit {
  
  fastResList: any = [];
  id: Number;
  vehicleList: any = [];
  discountForm: FormGroup;
  dateValid: boolean = true;

  constructor(private rentService: RentService,private route: ActivatedRoute,private fastService: FastVehicleService) { 
    this.route.params.subscribe(
      (params: Params) => {
        //uzmi id rent-a-car servisa iz putanje
        this.id = +params['id'];
      }
    );

    this.fastService.getFastRes(this.id).subscribe(
      (data) => {
        this.fastResList = data;
      },
      (error) => alert("nije nasao brze")
    )

    //pokupi sva vozila rentacarservisa
    this.rentService.getRENTVehicles(this.id).subscribe(
      (data) => {
        this.vehicleList = data;
      },
      (error) => {alert("nije nasao vozila za rent")}
    );
    }

  ngOnInit() {

    this.discountForm = new FormGroup({
      "startDate": new FormControl(''),
      "endDate": new FormControl(''),
      "discount": new FormControl(''),
    })

  }

  addVehicleToFast(event,idRes){
    var vFastDTO = {
      idVehicle: event.target.value,
      idRes: idRes,
    }

    this.fastService.addVehicleToRes(vFastDTO).subscribe(
      (success) => 
      {
        swal("Success","The vehicle is now on dicount!", "success");
      },
      (error) => {
        if(error.status === 500){
          swal("Error","Vehicle is already on discount.", "error");
        }else{
          swal("Error","error","error");
        }
      }
    )

  }

  onSubmitDiscount(){


    let start = new Date(this.discountForm.value.startDate);
    let end = new Date(this.discountForm.value.endDate);
    this.dateValid = this.validateDate(start,end);

    

    if(this.dateValid){
      var fastRes = {
        startDate: this.discountForm.value.startDate,
        endDate: this.discountForm.value.endDate,
        discount: this.discountForm.value.discount,
     };
     this.fastService.newFastRes(fastRes).subscribe(
       (data) => {
         this.fastResList.push(data);
          swal("Success","Please add a vehicle to the new discount period.","success");   
       },
       (error) => {alert(error)}
     )
    }
  }

    validateDate(start,end): boolean{
      if(end > start){
        return true;
      }else{
        return false;
      }
    }

}
