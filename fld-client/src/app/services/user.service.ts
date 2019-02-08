import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";

@Injectable()
export class UserService {

	constructor(private http: HttpClient) { }

    saveUser(user) {
        return this.http.post("http://localhost:4200/api/users", user);
    }

    login(user){
        return this.http.post("http://localhost:4200/api/auth/login",user);
    }

    getUsers() {
        return this.http.get('/api/users/all');
    }

    getUserInfo() {
        return this.http.get('/api/users/info');
    }

    regAdmin(user, role: string) {
        return this.http.post("/api/users/regAdmin/" + role, user);
    }

	}

