import { Component, OnInit } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { ActivatedRoute, Router, Params } from '@angular/router';
import swal from 'sweetalert';

@Component({
  selector: 'app-branches',
  templateUrl: './branches.component.html',
  styleUrls: ['./branches.component.css']
})
export class BranchesComponent implements OnInit {
  id: number;
  branchList: any;
  emptyBranchList: boolean = false;

  constructor(private service: RentService, private route: ActivatedRoute, private router: Router) {
    this.route.params.subscribe(
      (params: Params) => {
        //uzmi id rent-a-car servisa iz putanje
        this.id = +params['id'];
      }
    );
      if(this.id !== NaN && this.id !== undefined){
        this.service.getAllBranches(this.id).subscribe(
          (data) => {
            this.branchList = data;
            if(this.branchList.length === 0){
              this.emptyBranchList = true;
            }
          },
          (error) => {
            swal("Error", error.status ,"error")
            this.router.navigate(['/rent/administrateRents']);
          }
          )
      }

   }

  ngOnInit() {
    
  }



}
