import { Component, OnInit, ViewChild, AfterViewInit } from '@angular/core';
import { RentService } from 'src/app/services/rentacar.service';
import { ActivatedRoute, Router, Params, ChildActivationEnd } from '@angular/router';
import swal from 'sweetalert';
import { DataService } from 'src/app/services/data.service';
import { BranchFormComponent } from './branch-form/branch-form.component';
import { Subject } from 'rxjs';

@Component({
  selector: 'app-branches',
  templateUrl: './branches.component.html',
  styleUrls: ['./branches.component.css'],
})
export class BranchesComponent implements OnInit {
  id: number;
  branchList: any;
  emptyBranchList: boolean = false;
  showFormDialog: boolean = false;
  ID: string;
  isClosed: Subject<boolean> = new Subject();

  constructor(private service: RentService, private route: ActivatedRoute, private router: Router, private dataService: DataService) {
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
    this.dataService.edit.subscribe(data => this.ID = data);
    this.notifyChild(false);
  }

  onAddBranch(){
    this.showFormDialog = true;
  }
  onEditBranch(id){
    this.showFormDialog = true;
    this.dataService.changeID(id.toString());
  }

  onDeleteBranch(idF){
    swal({
      title: "Are you sure?",
      icon: "warning",
      buttons: ["Cancel", "Delete"],
      dangerMode: true,
    })
    .then((willDelete) =>{
      if(willDelete){
        this.service.deleteBranchOffice(idF).subscribe(
          (result) => {
            // fensi for petlja
            let i = this.branchList.findIndex(branch => branch.id === idF);
            // obrisi jednog clana na poziciji i
            this.branchList.splice(i, 1);
            if(this.branchList.length === 0) {
              this.emptyBranchList = true;
            }
          }, (error) => swal("Error", error, "error")
        );
      }
    })
  }

  onCloseForm(){
    this.notifyChild(true);
    this.showFormDialog = false;
  }

  branchSubmitted(response){
    if(this.ID !== undefined && this.ID !== ""){
      this.dataService.changeID(undefined);
      let i = this.branchList.findIndex(branch => branch.id === response.id)
      this.branchList.splice(i,1);
      this.branchList.push(response);
      this.showFormDialog = false;
      this.emptyBranchList = false;
    }else{
      this.branchList.push(response);
      this.showFormDialog = false;
      this.emptyBranchList = false;}
  }

  //obavestava child komponentu da je forma zatvorena
  notifyChild(value){
    this.isClosed.next(value);
  }

}
