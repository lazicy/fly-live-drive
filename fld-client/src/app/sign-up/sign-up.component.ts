import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { shallowEqualArrays } from '@angular/router/src/utils/collection';
import swal from 'sweetalert'
import { User } from '../model/user'

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  public model = new User('','','','','',''); //pravim prazan model koji se veze na formu

  constructor(private http: HttpClient) { }

  ngOnInit() {
  }


  onSubmitSignUp(form: NgForm){
    let user = {
      firstname: this.model.name,
      lastname: this.model.lastNname,
      username: this.model.username,
      password: this.model.password,
      email: this.model.email,
      city: this.model.city
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
