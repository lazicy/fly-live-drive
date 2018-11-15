import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';

@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
	public message: string;
	data: any;
	users: any;
	showUsers: boolean = false;
	constructor(private http: HttpClient) { }

	ngOnInit() {
		this.getData();
		this.getUsers();
		setTimeout(() => console.log(this.data), 3000);
	}

	getData() {
		return this.http.get("http://localhost:4200/api/testarino").subscribe(data => this.data = data);
	}

	getUsers() {
		return this.http.get("http://localhost:4200/api/users/all").subscribe(data => this.users = data);
	}

	onSubmitUser(form: NgForm) {
		const username = form.value.username;
		const firstname = form.value.firstname;
		const lastname = form.value.lastname;
		const email = form.value.email;

		let user = {
			username: username,
			firstname: firstname,
			lastname: lastname,
			email: email
		}


		this.saveUser(user);
		form.reset();


	}

	onReset(form: NgForm) {
		form.reset();
	}

	saveUser(user) {
		this.http.post("http://localhost:4200/api/users", user)
			.subscribe(
				(success) => {
					 console.log(success);
					 this.users.push(user);

				},
				error => console.log(error)
			);
	}

	onToggleUsers() {
		this.showUsers = !this.showUsers;	
	}

}
