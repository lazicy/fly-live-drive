import { Component } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'fld-client';
  isLogin: boolean = false;
  isSignUp: boolean = false;

  constructor(private route: Router){
    //prati promenu url-a
    this.route.events.subscribe(
			(val) => {
        if(route.url.includes("login")){
          this.isLogin = true;
        }else{
          this.isLogin = false;
        }

        if(route.url.includes("signup")){
          this.isSignUp = true;
        }else{
          this.isSignUp = false;
        }
      }
    );
    
  }

  ngOnInit() {
    
  }

}
