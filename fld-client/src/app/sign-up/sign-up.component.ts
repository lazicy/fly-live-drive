import { Component, OnInit } from '@angular/core';
import { NgForm, FormBuilder, FormGroup, Validators, FormControl } from '@angular/forms';
import { HttpClient, HttpErrorResponse } from '@angular/common/http';
import { shallowEqualArrays } from '@angular/router/src/utils/collection';
import swal from 'sweetalert';
import { User } from '../model/user';
import { UserService } from '../services/user.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-sign-up',
  templateUrl: './sign-up.component.html',
  styleUrls: ['./sign-up.component.css']
})
export class SignUpComponent implements OnInit {

  public model = new User('','','','','',''); //pravim prazan model koji se veze na formu
  myForm: FormGroup;
  firstName: FormControl;
  lastName: FormControl;
  userName: FormControl;
  password: FormControl;
  email: FormControl;
  city: FormControl;

  constructor(private http: HttpClient, private service: UserService,private router: Router) { }

  ngOnInit() {
    this.createFormControls();
    this.createForm();
  }

  createFormControls(){
    this.firstName = new FormControl('', Validators.required);
    this.lastName = new FormControl('', Validators.required)
    this.userName = new FormControl('', Validators.required);
    this.password = new FormControl('', Validators.required);
    this.email = new FormControl('', {validators: [Validators.required, Validators.email]});
    this.city = new FormControl('', Validators.required);
  }

  createForm(){
    this.myForm = new FormGroup({
      name: this.firstName,
      lastname: this.lastName,
      username: this.userName,
      email: this.email,
      password: this.password,
      city: this.city,
    });
  }

  onSubmitSignUp(form: NgForm){
    let user = {
      firstname: this.myForm.value.name,
      lastname: this.myForm.value.lastname,
      username: this.myForm.value.username,
      password: this.myForm.value.password,
      email: this.myForm.value.email,
      city: this.myForm.value.city
    }
    this.service.saveUser(user).subscribe(
      (success) => {
        //dodati: nakon uspesne registracije prebaciti korisnika na glavnu stranicu 
         swal("Success!","Your registration was successfull. Check your e-mail to confirm your account.", "success");
         this.router.navigate(['/home']);
      },
      error => console.log(error)
    );
    form.reset();
  }

 

}
