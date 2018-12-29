import { Component, OnInit, OnDestroy, Output, EventEmitter } from '@angular/core';
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
  currentRole: any;

  constructor(private http: HttpClient, private userService: UserService) { }

  ngOnInit() {

  }

  onSubmitUser(form: NgForm) {
    const role = form.value.role;
  }

  ngOnDestroy() {
		this.userSubmit.unsubscribe();
	}

}
