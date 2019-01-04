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

  constructor(private http: HttpClient, private userService: UserService) { }

  ngOnInit() {
    if(this.currRole === "USER") {
      this.role = "USER";
    } else if (this.currRole === "AVIO_ADMIN") {
      this.role = "AVIO_ADMIN";
    } else if (this.currRole === "HOTEL_ADMIN") {
      this.role = "HOTEL_ADMIN";
    } else {
      this.role = "RENT_ADMIN";
    }
  }

  onSubmitUser(form: NgForm) {
    const newR = form.value.role;

    this.userService.changeRole(this.user, newR).subscribe(
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
