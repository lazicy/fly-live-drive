import { Component } from '@angular/core';
import { ActivatedRoute, Params, Router } from '@angular/router';
import { routerNgProbeToken } from '@angular/router/src/router_module';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'fld-client';
  isLogin: boolean = false;
  isSignUp: boolean = false;
  isVerifed: boolean = false;


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

        if(route.url.includes("verifymail")){
          this.isVerifed = true;
        }else{
          this.isVerifed = false;
        }

      }
    );
    
  }

  ngOnInit() {
    
  }

}
