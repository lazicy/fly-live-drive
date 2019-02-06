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

	// getAvioList() {
	// 	return this.avios.slice();
	// }

	// GET all
	getAvios() {
		return this.http.get("/api/avio/all");
	}

	// GET one
	getAvio(id: number) {
		return this.http.get("/api/avio/" + id);
	}

	// POST one
	saveAvio(avio) {
		return this.http.post("/api/avio", avio);
	}

	// UPDATE one
	updateAvio(avio) {
		return this.http.put("/api/avio", avio);
	}

	deleteAvio(id: number) {
		return this.http.delete("/api/avio/" + id);
	}

	// GET all flights for specified avio
	getAviosFlights(id: number) {
		return this.http.get("/api/avio/" + id + "/flights");
	}

	// GET all destinations for specified avio
	getAviosDestinations(id: number) {
		return this.http.get("/api/avio/" + id + "/destinations");
	}

	// POST destination for specified avio
	saveAviosDestination( destination) {
		return this.http.post("/api/avio/destinations", destination);
	}

	

	



	
	
	
}
