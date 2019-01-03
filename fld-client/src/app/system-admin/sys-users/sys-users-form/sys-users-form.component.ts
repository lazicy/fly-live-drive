import { Component, OnInit, OnDestroy, Output, EventEmitter, Input } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from 'src/app/services/user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-sys-users-form',
  templateUrl: './sys-users-form.component.html',
  styleUrls: ['./sys-users-form.component.css']
})
export class SysUsersFormComponent implements OnInit, OnDestroy {

  @Output() userSubmit = new EventEmitter();
  @Input() user: any;
  @Input() currRole: any;
  role: any;
  newId: any;
  newR: any;

  constructor(private http: HttpClient, private userService: UserService) { }

  ngOnInit() {
    if(this.currRole === "USER") {
      this.role = 1;
    } else if (this.currRole === "AVIO_ADMIN") {
      this.role = 2;
    } else if (this.currRole === "HOTEL_ADMIN") {
      this.role = 3;
    } else {
      this.role = 4;
    }
  }

  onSubmitUser(form: NgForm) {
    const role = form.value.role;
    
    if(role === "1") {
      this.newR = "USER";
      this.newId = 5;
    } else if (role === "2") {
      this.newR = "AVIO_ADMIN";
      this.newId = 3;
    } else if (role === "3") {
      this.newR = "HOTEL_ADMIN";
      this.newId = 2;
    } else {
      this.newR = "RENT_ADMIN";
      this.newId = 1;
    }
    this.user.authorities[0].name = this.newR;
    this.user.authorities[0].id = this.role;

    this.userService.changeRole(this.user).subscribe(
      (response) => {
        this.userSubmit.emit(response);
        swal({title: "Success!", text: "User role changed", icon: "success", timer: 1500});
				this.ngOnDestroy();
      },
      (error) => {swal ( "Error occured" ,  "User role was not changed." ,  "error" );}
    );
  }

  ngOnDestroy() {
		this.userSubmit.unsubscribe();
	}

}
