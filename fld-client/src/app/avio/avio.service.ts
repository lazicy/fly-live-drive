import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Subject } from 'rxjs';

@Injectable()
export class AvioService {
	avios: any;
	aviosChanged = new Subject();

	constructor(private http: HttpClient) { }

	getAvios() {
		this.http.get("http://localhost:4200/api/avio/all")
			.subscribe(data => {
				this.avios = data;
				// informing subscribed components that a list is changed
				this.aviosChanged.next(this.getAvioList());

			},
			error => console.log(error));
	}

	getAvioList() {
		return this.avios.slice();
	}



	
	
	
}
