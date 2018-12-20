import { Component, OnInit } from '@angular/core';
import { UserService } from '../services/user.service';
import { NgForm } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from '../services/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  constructor(private service: AuthService, private router: Router) { }

  ngOnInit() {
  }


  loginUser(form: NgForm){

    let user = {
      username: form.value.username,
      password: form.value.password,
    }

    this.service.login(user).subscribe(
      (success) => {
        this.router.navigate(['/test']);
      },
      (error) => {
        console.log(error);
      }
    )
    form.reset();
  }

}