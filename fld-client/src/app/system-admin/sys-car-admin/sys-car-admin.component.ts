import { Component, OnInit } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-sys-car-admin',
  templateUrl: './sys-car-admin.component.html',
  styleUrls: ['./sys-car-admin.component.css']
})
export class SysCarAdminComponent implements OnInit {
  
  showFormDialog: boolean = false;
  rentList: any;
  emptyRentList: boolean;

  constructor(private http: HttpClient, private service: RentService) { }

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
    swal({
      title: "Are you sure?",
      icon: "warning",
      buttons: ["Cancel", "Delete"],
      dangerMode: true,
    })
    .then((willDelete) => {
      if (willDelete) {
        this.service.deleteRent(id).subscribe(
          (result) => {
            // fensi for petlja
            let i = this.rentList.findIndex(rent => rent.id === id);
            // obrisi jednog clana na poziciji i
            this.rentList.splice(i, 1);
            swal({title: "Success!", text: "Rent-A-Car company deleted.", icon: "success", timer: 1500});
            if(this.rentList.length === 0) {
              this.emptyRentList = true;
            }
          }, (error) => {swal ( "Error occured" ,  "The company was not deleted." ,  "error" );}
        );
      }
    });
		
    
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
