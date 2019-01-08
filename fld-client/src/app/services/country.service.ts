import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
	providedIn: 'root'
})
export class CountryService {

	constructor(private http: HttpClient) { }

	// GET all countries
	getCountries() {
		return this.http.get("/api/country/all");
	}

	// GET by ID
	getCountryById(id: number) {
		return this.http.get("/api/country/" + id);
	}

	// GET one country's cities
	getCountysCities(id: number) {
		return this.http.get("/api/country/" + id + "/cities");
	}




}
