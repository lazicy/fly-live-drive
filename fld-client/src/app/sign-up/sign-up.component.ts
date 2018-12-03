import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient } from '@angular/common/http';
import { shallowEqualArrays } from '@angular/router/src/utils/collection';
import swal from 'sweetalert'

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  constructor(private http: HttpClient) { }

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
      firstname: name,
      lastname: lastname,
      username: username,
      password: password,
      email: email,
      city: city
    }

    this.saveUser(user);
    form.reset();

  }

  saveUser(user){
    this.http.post("http://localhost:4200/api/users", user)
    .subscribe(
      (success) => {
        //dodati: nakon uspesne registracije prebaciti korisnika na glavnu stranicu 
         console.log(success);
         swal("Success!","Welcome "+ user.username, "success");
      },
      error => console.log(error)
    );
  }

}
