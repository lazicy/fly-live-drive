import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable()
export class UserService {

	constructor(private http: HttpClient) { }

    saveUser(user){
        return this.http.post("http://localhost:4200/api/users", user);
      }

    login(user){
        return this.http.post("http://localhost:4200/api/auth/login",user);
    }

	}

