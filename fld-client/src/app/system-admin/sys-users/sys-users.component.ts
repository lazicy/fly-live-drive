import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { UserService } from 'src/app/services/user.service';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-sys-users',
  templateUrl: './sys-users.component.html',
  styleUrls: ['./sys-users.component.css']
})
export class SysUsersComponent implements OnInit {
  role: any;

  constructor(private http: HttpClient, private userService: UserService) { }

  ngOnInit() {
    this.role = "AVIO_ADMIN";
  }

  onSubmitAdmin(form: NgForm) {
    const name = form.value.name;
    const lastname = form.value.lastname;
    const username = form.value.username;
    const email = form.value.email;
    const password = form.value.password;
    const city = form.value.city;

    let user = {
      firstname: name,
      lastname: lastname,
      username: username,
      password: password,
      email: email,
      city: city
    }

    this.userService.regAdmin(user, this.role).subscribe(
      (response) => {
        swal({title: "Admin added!", text: "Check the e-mail to confirm your account.", icon: "success"});
        form.reset();
      },
      (error) => {swal ( "Error occured" ,  "Admin was not added." ,  "error" );}
    );
  }

  onReset(form: NgForm) {
    form.reset();
  }


}
