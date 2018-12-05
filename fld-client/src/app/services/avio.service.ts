import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Subject } from 'rxjs';

@Injectable()
export class AvioService {
	avios: any;
	aviosChanged = new Subject();

	constructor(private http: HttpClient) { }

	// getAvios() {
	// 	this.http.get("/api/avio/all")
	// 		.subscribe(data => {
	// 			this.avios = data;
	// 			// informing subscribed components that a list is changed
	// 			this.aviosChanged.next(this.getAvioList());

	// 		},
	// 		error => console.log(error));
	// }

	getAvioList() {
		return this.avios.slice();
	}

	getAvios() {
		return this.http.get("/api/avio/all");
	}

	saveAvio(avio) {
		return this.http.post("http://localhost:4200/api/avio", avio);
	}

	getAvio(id) {
		return this.http.get("/api/avio/" + id);
	}

	getAviosFlights(id) {
		return this.http.get("/api/avio/" + id + "/flights");
	}

	getAviosDestinations(id) {
		return this.http.get("/api/avio/" + id + "/destinations");
	}

	saveAviosDestination(id, destination) {
		return this.http.post("/api/avio/" + id + "/destinations", destination);
	}



	



	
	
	
}
