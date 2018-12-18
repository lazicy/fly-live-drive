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
import com.bff.flylivedrive.dto.mappers.FlightMapper;
import com.bff.flylivedrive.dto.mappers.InterceptionMapper;
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
		
		// find avio in database
		Avio a = avioService.findOneById(flightDTO.getAvioDTO().getId());
		
		// if there is no any bad request
		if (a == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		// find cities in database
		City departureCity = cityService.findOneById(flightDTO.getDepartureCity().getId());
		City landingCity = cityService.findOneById(flightDTO.getLandingCity().getId());
		
		// if one of them is null - bad request
		if (departureCity == null || landingCity == null) {
			return new ResponseEntity<>(HttpStatus.valueOf("Departure city or landing city not found"));
		}
		
		// map flight [interceptions will be set latter because they need flight reference]
		FlightMapper mapper = new FlightMapper();
		Flight flight = mapper.map(flightDTO, a, departureCity, landingCity);
		
		// form and map all interceptions 
		Set<Interception> interceptions = formInterceptionsSet(flightDTO.getInterceptionsDTO(), flight);
		
		if (interceptions == null) {
			return new ResponseEntity<>(HttpStatus.valueOf("One of interception cities not found."));
		}
		
		flight.setInterceptions(interceptions);
		
		// save to database
		flight = flightService.save(flight);
		
		return new ResponseEntity<>(new FlightDTO(flight), HttpStatus.CREATED);
		
	}
	
	
	// forming set of interceptions
	private Set<Interception> formInterceptionsSet(List<InterceptionDTO> interceptionsDTO, Flight f) {
		Set<Interception> interceptions = new HashSet<>();
		for (InterceptionDTO iDTO: interceptionsDTO) {
			
			
			// find interception city
			City c = cityService.findOneById(iDTO.getCityDTO().getId());
			
			// return null if there isn't any 
			if (c == null) {
				return null;
			}
			
			InterceptionMapper mapper = new InterceptionMapper();
			Interception i = new Interception();
			i = mapper.map(iDTO, c, f);
			
			// finaly put it in set
			interceptions.add(i);
			
		}
		
		return interceptions;
		
		
	}
	
	

}
