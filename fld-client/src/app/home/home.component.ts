import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { AuthService } from '../services/auth.service';
import { UserService } from '../services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent implements OnInit {

  firstLog: boolean = false;
  getdejta: any;
  usr: string;
  showUsers: boolean = false;
  
  constructor(private service: AuthService, private http: HttpClient, private userService: UserService) { }

  ngOnInit() {
    this.service.getUser().subscribe(
      (data) => {
        this.usr = data;
        this.checkUser();
      },
      (error) => { alert(error);}
    );
  }

  ngOnDestroy() {
    
  }

  checkUser() {
    if(this.usr !== "") {
      this.userService.getFirstLog(this.usr).subscribe(
        (success) => {
          this.getdejta = success;
          if(this.getdejta === 1) {
            this.firstLog = true;
          }
        },
        (error) => {
          swal("Error","First Log","error");
        }
      );
    }
  }

  passSubmitted(ok) {
    this.firstLog = false;
    if(ok) {
      swal({title: "Success!", text: "Password has been changed", icon: "success", timer: 1500});
    } else {
      swal ( "Error occured" ,  "Password was not changed",  "error" );
    }
  }

}
