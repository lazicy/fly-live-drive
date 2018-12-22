import { Component, OnInit } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-rent-admin',
  templateUrl: './rent-admin.component.html',
  styleUrls: ['./rent-admin.component.css']
})
export class RentAdminComponent implements OnInit {
  showFormDialog: boolean = false;
  rentList: any;
  emptyRentList: boolean;

  constructor(private service: RentService) { }

  ngOnInit() {

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

  onEditRent(id){

  }

  onCloseForm(){
    this.showFormDialog = false;
  }

  rentSubmitted(response){
    this.rentList.push(response);
    this.showFormDialog = false;
    this.emptyRentList = false;
  }

  

}
