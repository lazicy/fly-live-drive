import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router, Params } from '@angular/router';
import { RentService } from 'src/app/services/rentacar.service';
import { NgForm } from '@angular/forms';
import { DataService } from 'src/app/services/data.service';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-vehicles',
  templateUrl: './vehicles.component.html',
  styleUrls: ['./vehicles.component.css']
})
export class VehiclesComponent implements OnInit {
  idR: number;
  idF: number;
  ID: string;
  vehicleList: any;
  emptyVehicleList: boolean = false;
  showFormDialog: boolean = false;
  isClosed: Subject<boolean> = new Subject();


  constructor(private service: RentService,private route: ActivatedRoute, private router: Router, private dataService: DataService) {
    this.route.params.subscribe(
      (params: Params) => {
        this.idR = +params['idR'];
        this.idF = +params['idF'];
      }
    )
      if(this.idF !== NaN && this.idF !== undefined){
        this.service.getAllVehicles(this.idF).subscribe(
          (data) => {
            this.vehicleList = data;
            if(this.vehicleList.length === 0){
              this.emptyVehicleList = true;
            }
          },
          (error) => {
            swal("Error",error.message,"error");
            this.router.navigate(['/rent/administrateRents']);
          }
        )
      }
   }

  ngOnInit() {
    this.dataService.edit.subscribe(data => this.ID = data);
    this.notifyChild(false);
  }

  onEditVehicle(id,vehicles){
    this.showFormDialog = true;
    this.dataService.changeID(id.toString());
  }

  onAddVehicle(){
    this.showFormDialog = true;
  }
  
  onDeleteVehicle(id){
    swal({
      title: "Are you sure?",
      icon: "warning",
      buttons: ["Cancel", "Delete"],
      dangerMode: true,
    })
    .then((willDelete) =>{
      if(willDelete){
        this.service.deleteVehicle(id).subscribe(
          (result) => {
            // fensi for petlja
            let i = this.vehicleList.findIndex(vehicle => vehicle.id === id);
            // obrisi jednog clana na poziciji i
            this.vehicleList.splice(i, 1);
            if(this.vehicleList.length === 0) {
              this.emptyVehicleList = true;
            }
          }, (error) => {
              if(error.status === 403){
                swal("Error","Vehicle is reserved. You cant make any changes.","error")
              }else{
                alert(error);
              }            
            }
        );
      }
    })
  }

  vehicleSubmitted(response){
    if(this.ID !== undefined && this.ID !== ""){
      this.dataService.changeID(undefined);
      let i = this.vehicleList.findIndex(vehicle => vehicle.id === response.id);
      this.vehicleList.splice(i,1);
      this.vehicleList.push(response);
      this.showFormDialog = false;
      this.emptyVehicleList = false;
    }else{
      this.vehicleList.push(response);
      this.showFormDialog = false;
      this.emptyVehicleList = false;
    }
  }

  onCloseForm(){
    this.showFormDialog = false;
    this.notifyChild(true);
  }

  //obavestava child komponentu da je forma zatvorena
  notifyChild(value){
    this.isClosed.next(value);
  }
}
