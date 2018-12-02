import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  constructor() { }

  ngOnInit() {
  }


  onSubmitSignUp(form: NgForm){
    
    const name = form.value.name;
    const lastname = form.value.lastname;
    const password = form.value.password;
    const username = form.value.username;
    const city = form.value.city;
    const email = form.value.email;

    let user = {
      name: name,
      lastname: lastname,
      username: username,
      password: password,
      email: email,
      city: city
    }

    //this.saveUser(user);

    form.reset();

  }

}
