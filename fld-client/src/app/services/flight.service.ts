import { HttpClient } from '@angular/common/http';
import { Injectable } from "@angular/core";
import { Subject } from 'rxjs';

@Injectable()
export class FlightService {
	

    constructor(private http: HttpClient) { }
    
    saveFlight(flight) {
        return this.http.post("/api/flight", flight);
    }

    getFlight(id) {
        return this.http.get("/api/flight/" + id);
    }

    getFlightSeats(id) {
        return this.http.get("/api/flight/" + id + "/seats");
    }

    searchFlights(searchParams) {
		return this.http.post("/api/flight/search", searchParams);
	}


}

