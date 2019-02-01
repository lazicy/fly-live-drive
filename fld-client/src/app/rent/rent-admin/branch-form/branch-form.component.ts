import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { identifierModuleUrl } from '@angular/compiler';
import { RentACar } from 'src/app/model/rentacar';
import { RentService } from 'src/app/services/rentacar.service';
import { DataService } from 'src/app/services/data.service';

@Component({
  selector: 'app-branch-form',
  templateUrl: './branch-form.component.html',
  styleUrls: ['./branch-form.component.css']
})
export class BranchFormComponent implements OnInit {
  id: number;
  rent: any;
  ID: string;
  @Output() branchSubmit = new EventEmitter();

  constructor(private service: RentService,private route: ActivatedRoute, private dataService: DataService) {
    this.route.params.subscribe(
      (params: Params) => {
        //uzmi id rent-a-car servisa iz putanje
        this.id = +params['idR'];
      }
    ); 
  }

  ngOnInit() {
    this.dataService.edit.subscribe(data => this.ID = data); //subscribe na edit (cuva info da li se radi edit ili ne)
  }
  
  onSubmitBranch(form: NgForm){
    const address =  form.value.address;
    const city = form.value.city;
    const country = form.value.country;
    var branch = {
      address: address,
      city: city,
      country: country,
    }

    if(this.ID !== undefined && this.ID !== ""){
      var branchTemp = {
        id: +this.ID,
        address: address,
        city: city,
        country: country,
      }
      this.service.editBranchOffice(branchTemp,this.id).subscribe(
        (response) => {
          this.branchSubmit.emit(response);
          this.ngOnDestroy();
        },
        (error) => {alert(error); return;} 
      )
    }else{
      this.service.addBranchOffice(branch,this.id).subscribe(
        (response) => {
          this.branchSubmit.emit(response);
          this.ngOnDestroy();
        },
        (error) => swal("Error", "error")
      );
    }
    form.reset();
  }

  onReset(form: NgForm){
    form.reset();
  }
  ngOnDestroy(){
    this.branchSubmit.unsubscribe();
  }
}
