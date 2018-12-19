import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import {map} from 'rxjs/operators';



@Injectable()
export class AuthService {

	constructor(private http: HttpClient) { }

    login(user){
        return this.http.post('http://localhost:4200/api/auth/login',user)
        .pipe(
            map(user => {

                if(user && user.accessToken){
                    localStorage.setItem('currentUser', JSON.stringify(user));
                }

                return user;
            })
        )
    }

    logout(){
        localStorage.removeItem('currentUser');
    }

    getUser(){
        return this.http.get('http://localhost:4200/api/users/getUser');
    }

}

