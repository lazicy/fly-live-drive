import { Component, OnInit } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { NgForm } from '@angular/forms';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-rent-admin',
  templateUrl: './rent-admin.component.html',
  styleUrls: ['./rent-admin.component.css']
})
export class RentAdminComponent implements OnInit {
  showFormDialog: boolean = false;
  rentList: any;
  emptyRentList: boolean;
  ID: string;

  constructor(private service: RentService, private dataService: DataService) { }

  ngOnInit() {
    this.dataService.edit.subscribe(data => this.ID = data);

    this.service.getServices().subscribe(
        (data) => {
          this.rentList = data;
          
          if(this.rentList.length === 0){
            this.emptyRentList = true;
          }
          
        },
        (error) => {
          swal("Error", error, "error");
        }

      )
  }


  onAddRent(){
    this.showFormDialog = true;  
  }

  onDeleteRent(id){
    // nakon upucenog delete requesta, nema potrebe da se ponovo dobavlja lista sa servera, vec se samo taj objekat izbaci iz liste sa klijenta
    swal({
      title: "Are you sure?",
      icon: "warning",
      buttons: ["Cancel", "Delete"],
      dangerMode: true,
    })
    .then((willDelete) =>{
      if(willDelete){
        this.service.deleteRent(id).subscribe(
          (result) => {
            // fensi for petlja
            let i = this.rentList.findIndex(rent => rent.id === id);
            // obrisi jednog clana na poziciji i
            this.rentList.splice(i, 1);
            if(this.rentList.length === 0) {
              this.emptyRentList = true;
            }
          }, (error) => swal("Error", error, "error")
        );
      }
    })
    }

  onEditRent(id){
    this.showFormDialog = true;
    this.dataService.changeID(id.toString());
  }

  onCloseForm(){
    this.showFormDialog = false;
  }

  rentSubmitted(response){
    if(this.ID !== undefined && this.ID !== ""){
      this.dataService.changeID(undefined);
      let i = this.rentList.findIndex(rent => rent.id === response.id)
      this.rentList.splice(i,1);
      this.rentList.push(response);
      this.showFormDialog = false;
      this.emptyRentList = false;
    }else{
      this.rentList.push(response);
      this.showFormDialog = false;
      this.emptyRentList = false;
    }
  }
}
