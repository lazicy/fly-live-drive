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
  @Input() currentRole: any;
  @Input() userId: any;
  role: any;

  constructor(private http: HttpClient, private userService: UserService) { }

  ngOnInit() {
    if(this.currentRole === "USER") {
      this.role = 1;
    } else if (this.currentRole === "AVIO_ADMIN") {
      this.role = 2;
    } else if (this.currentRole === "HOTEL_ADMIN") {
      this.role = 3;
    } else {
      this.role = 4;
    }
  }

  onSubmitUser(form: NgForm) {
    const role = form.value.role;
  }

  ngOnDestroy() {
		this.userSubmit.unsubscribe();
	}

}
