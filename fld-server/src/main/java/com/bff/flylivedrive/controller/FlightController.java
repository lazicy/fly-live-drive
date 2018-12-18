package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.HashSet;
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

import com.bff.flylivedrive.dto.FlightDTO;
import com.bff.flylivedrive.dto.InterceptionDTO;
import com.bff.flylivedrive.model.Avio;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Flight;
import com.bff.flylivedrive.model.Interception;
import com.bff.flylivedrive.service.AvioService;
import com.bff.flylivedrive.service.CityService;
import com.bff.flylivedrive.service.FlightService;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	@Autowired
	AvioService avioService;
	@Autowired
	CityService cityService;

	// Get ALL flights of ALL avios
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<FlightDTO>> getAllFlight(){
		
		System.out.println("getAllFlight");
		
		
		
		List<Flight> flights = flightService.findAll();
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		// konverzija u DTO
		for (Flight f: flights) {
			FlightDTO fDTO = new FlightDTO(f);
			flightsDTO.add(fDTO);
		}
		
		return new ResponseEntity<>(flightsDTO, HttpStatus.OK);
	}
	
	// Get ONE flight
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<FlightDTO> getFlight(@PathVariable Long id) {
		
		Flight flight = flightService.findOneById(id);
		
		if(flight == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new FlightDTO(flight), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<FlightDTO> saveFlight(@RequestBody FlightDTO flightDTO) {
		
		if (flightDTO.getAvioDTO() == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Avio a = avioService.findOneById(flightDTO.getAvioDTO().getId());
		System.out.println(a);
		if (a == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Flight flight = new Flight();
		flight.setId(flightDTO.getId());
		flight.setDepartureDate(flightDTO.getDepartureDate());
		flight.setLandingDate(flightDTO.getLandingDate());
		flight.setPrice(flightDTO.getPrice());
		flight.setAvio(a);
		
		City departureCity = cityService.findOneById(flightDTO.getDepartureCity().getId());
		City landingCity = cityService.findOneById(flightDTO.getLandingCity().getId());
		
		if (departureCity == null || landingCity == null) {
			return new ResponseEntity<>(HttpStatus.valueOf("Departure city or landing city not found"));
		}
		
		System.out.println(landingCity.getName());
		flight.setDepartureCity(departureCity);
		flight.setLandingCity(landingCity);
		
		// set all interceptions [BRACE YOURSELVES very crazy shit is comming]
		Set<Interception> interceptions = new HashSet<>();
		for (InterceptionDTO iDTO: flightDTO.getInterceptionsDTO()) {
			
			Interception i = new Interception();
			
			// set city
			City interceptionCity = cityService.findOneById(iDTO.getCity().getId());
			
			if (interceptionCity == null) {
				return new ResponseEntity<>(HttpStatus.valueOf("Interception city not found."));
			}
			
			// set interception
			i.setCity(interceptionCity);
			i.setDuration(iDTO.getDuration());
			i.setTakeOff(iDTO.getTakeOff());
			i.setLanding(iDTO.getLanding());
			i.setFlight(flight);
			
			// finaly put it in set
			interceptions.add(i);
			
		}
		flight.setInterceptions(interceptions);
		
		flight = flightService.save(flight);
		
		return new ResponseEntity<>(new FlightDTO(flight), HttpStatus.CREATED);
		
	}
	
	

}
