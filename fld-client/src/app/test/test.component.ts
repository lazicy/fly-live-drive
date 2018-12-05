import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { NgForm } from '@angular/forms';
import { AvioService } from '../services/avio.service';
import { FlightService } from '../services/flight.service';


@Component({
  selector: 'app-test',
  templateUrl: './test.component.html',
  styleUrls: ['./test.component.css']
})
export class TestComponent implements OnInit {
	public message: string;
	users: any;
	avioList: any;
	showUsers: boolean = false;
	constructor(private http: HttpClient, private avioService: AvioService, private flightService: FlightService) { }
	

	ngOnInit() {
		this.getUsers();
		

		this.avioService.getAvios()
			.subscribe(
				(data) => { 
					this.avioList = data;
					if (this.avioList.length === 0) {
						this.avioList = null;
					}
				},
				(error) => console.error(error)
			);
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

	onSubmitAvio(form: NgForm) {
		const name = form.value.name;
		const description = form.value.description;

		let avio = {
			name: name,
			description: description

		}

		console.log(avio);

		this.saveAvio(avio);
		form.reset();


	}

	onSubmitFlight(form: NgForm) {
		const avioId = form.value.avioId;
		const departureDate = form.value.departureDate;
		const landingDate = form.value.landingDate;
		const price = form.value.price;

		let flight = {
			avioDTO: this.avioList[avioId-1],
			departureDate: departureDate,
			landingDate: landingDate,
			price: price
		}

		console.log(flight);

		this.flightService.saveFlight(flight).subscribe(
			response => console.log(response),
			error => console.log(error)
		);
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

	saveAvio(avio) {
		this.http.post("http://localhost:4200/api/avio", avio)
			.subscribe(
				(success) => {
					 console.log(success);
				},
				error => console.log(error)
			);
	}

	onToggleUsers() {
		this.showUsers = !this.showUsers;	
	}

}
