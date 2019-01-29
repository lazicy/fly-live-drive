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

	// helper method - find index of a city in a list 
	findCityIndex(id: number, cities: any):number {
		// uzmi index iz liste na osnovu selektovanog id-a u html selectu
		return cities.findIndex(city => city.id ==id);
	}

	// helper method - make Country -> Cities structure 
	formatCCStructure(destinations: any) {

		let destCountries = [];
	
		for(let city of destinations) {
		  
		  let match = false;
		  for (let country of destCountries) {
			if (country.id === city.countryDTO.id) {
			
				country.cities.push(city);
				match = true;
				break;
			}
		  }
	
		  if (!match) {
			city.countryDTO.cities = [];
			city.countryDTO.cities.push(city);
			destCountries.push(city.countryDTO);
		  }
	
	
		}
	
		return destCountries;
	  }



}
