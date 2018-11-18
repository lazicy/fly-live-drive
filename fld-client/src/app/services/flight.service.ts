import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Subject } from 'rxjs';

@Injectable()
export class FlightService {
	

    constructor(private http: HttpClient) { }
    
    saveFlight(flight) {
        return this.http.post("/api/flight", flight);
    }

}

