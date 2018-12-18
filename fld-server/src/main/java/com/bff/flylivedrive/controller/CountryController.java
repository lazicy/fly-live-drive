package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bff.flylivedrive.dto.CityDTO;
import com.bff.flylivedrive.dto.CountryDTO;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Country;
import com.bff.flylivedrive.service.CountryService;

@RestController
@RequestMapping(value = "/country")
public class CountryController {
	
	@Autowired
	CountryService countryService;
	
	// Get ALL countries (including its citiesDTO)
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<CountryDTO>> getAllCountries(){
		
		List<Country> countries = countryService.findAll();
		List<CountryDTO> countriesDTO = new ArrayList<>();
		
		// konverzija u DTO
		for (Country c: countries) {
			CountryDTO cDTO = new CountryDTO(c);
			countriesDTO.add(cDTO);
		}
		
		return new ResponseEntity<>(countriesDTO, HttpStatus.OK);
	}
	
	// Get ONE country by ID
	@RequestMapping(value = "/{countryId}", method = RequestMethod.GET) 
	public ResponseEntity<CountryDTO> getOneCountry(@PathVariable Long countryId) {
	
		Country country = countryService.findOneById(countryId);
		
		if(country == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new CountryDTO(country), HttpStatus.OK);
	}
	
	
	// Post ONE country
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<CountryDTO> saveCountry(@RequestBody CountryDTO countryDTO) {
	
		Country country = new Country();
		country.setName(countryDTO.getName());

		country = countryService.save(country);
		
		return new ResponseEntity<>(new CountryDTO(country), HttpStatus.CREATED);
		
	}
	
	
	// Post ONE city to ONE country
	@RequestMapping(value = "/{countryId}/city", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<CityDTO> saveCity(@RequestBody CityDTO cityDTO, @PathVariable Long countryId) {
		
		
		
		Country country = countryService.findOneById(countryId);
		
		if (country == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		Set<City> cities = country.getCites();
		
		for (City c: cities) {
			// provera da li postoji grad iz iste drzave vec upisan
			if (c.getName().equals(cityDTO.getName())) {
				// http 409 conflict
				return new ResponseEntity<>(HttpStatus.CONFLICT);
				
			}
		}
		
		City city = new City();
		city.setName(cityDTO.getName());
		city.setCountry(country);

		cities.add(city);
		
		countryService.save(country);
		
		return new ResponseEntity<>(new CityDTO(city), HttpStatus.CREATED);
		
	}
	
	
	
	

}
