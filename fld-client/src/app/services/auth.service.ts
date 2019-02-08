import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import {map} from 'rxjs/operators';
import { Router } from '@angular/router';



@Injectable()
export class AuthService {

	constructor(private http: HttpClient, private router: Router) { }

    login(user){
        return this.http.post('http://localhost:4200/api/auth/login',user)
        .pipe(
            map(user => {

                if(user){
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }

                return user;
            })
        )
    }

    logout(){
        localStorage.removeItem('currentUser');
        window.location.reload();
        this.router.navigate(['/test']);
    }

    getUser(){
        return this.http.get('/api/users/getUser', {responseType: 'text'});
    }
}

