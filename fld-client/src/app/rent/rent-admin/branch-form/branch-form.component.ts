import { Component, OnInit, Output, EventEmitter } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Params } from '@angular/router';
import { identifierModuleUrl } from '@angular/compiler';
import { RentACar } from 'src/app/model/rentacar';
import { RentService } from 'src/app/services/rentacar.service';

@Component({
  selector: 'app-branch-form',
  templateUrl: './branch-form.component.html',
  styleUrls: ['./branch-form.component.css']
})
export class BranchFormComponent implements OnInit {
  id: number;
  rent: any;
  @Output() branchSubmit = new EventEmitter();

  constructor(private service: RentService,private route: ActivatedRoute) {
    this.route.params.subscribe(
      (params: Params) => {
        //uzmi id rent-a-car servisa iz putanje
        this.id = +params['id'];
      }
    ); 
  }

  ngOnInit() {
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
        this.service.addBranchOffice(branch,this.id).subscribe(
          (response) => {
            this.branchSubmit.emit(response);
            this.ngOnDestroy();
          },
          (error) => swal("Error", "error")
        );
    
    form.reset();
  }

  onReset(form: NgForm){
    form.reset();
  }
  ngOnDestroy(){
    this.branchSubmit.unsubscribe();
  }
}
