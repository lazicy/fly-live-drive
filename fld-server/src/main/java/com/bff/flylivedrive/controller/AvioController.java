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

import com.bff.flylivedrive.dto.AvioDTO;
import com.bff.flylivedrive.dto.CityDTO;
import com.bff.flylivedrive.dto.FlightDTO;
import com.bff.flylivedrive.model.Avio;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Flight;
import com.bff.flylivedrive.service.AvioService;

@RestController
@RequestMapping(value = "/avio")
public class AvioController {
	
	@Autowired
	AvioService avioService;
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<AvioDTO>> getAllAvio(){
		
		System.out.println("getAllAvio");
		
		List<Avio> avios = avioService.findAll();
		List<AvioDTO> aviosDTO = new ArrayList<>();
		
		// konverzija u DTO
		for (Avio a: avios) {
			AvioDTO aDTO = new AvioDTO(a);
			aviosDTO.add(aDTO);
		}
		
		return new ResponseEntity<>(aviosDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AvioDTO> getAvio(@PathVariable Long id) {
		
		Avio avio = avioService.findOneById(id);
		
		if(avio == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new AvioDTO(avio), HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<AvioDTO> saveAvio(@RequestBody AvioDTO avioDTO) {
		
		Avio avio = new Avio();

		avio.setName(avioDTO.getName());
		avio.setDescription(avioDTO.getDescription());
		
		avio = avioService.save(avio);
		
		return new ResponseEntity<>(new AvioDTO(avio), HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value = "/{avioId}/flights", method = RequestMethod.GET)
	public ResponseEntity<List<FlightDTO>> getAviosFlights(@PathVariable Long avioId) {

		Avio avio = avioService.findOneById(avioId);
		Set<Flight> flights = avio.getFlights();
		List<FlightDTO> flightsDTO = new ArrayList<>();
		
		for (Flight f : flights) {
			FlightDTO fDTO = new FlightDTO(f);
			
			flightsDTO.add(fDTO);
		}
		
		return new ResponseEntity<>(flightsDTO, HttpStatus.OK); 
		
	}
	
	@RequestMapping(value = "/{avioId}/destinations", method = RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> getAviosDestinations(@PathVariable Long avioId) {

		Avio avio = avioService.findOneById(avioId);
		Set<City> destinations = avio.getDestinations();
		List<CityDTO> destinationsDTO = new ArrayList<>();
		
		for (City d : destinations) {
			CityDTO dDTO = new CityDTO(d);
			
			destinationsDTO.add(dDTO);
		}
		
		return new ResponseEntity<>(destinationsDTO, HttpStatus.OK); 
		
	}
	
	
	@RequestMapping(value = "/{avioId}/destinations", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<CityDTO> saveDestination(@RequestBody CityDTO destinationDTO, @PathVariable Long avioId) {
		
		
		
		Avio a = avioService.findOneById(avioId);
		System.out.println(a);
		if (a == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		City destination = new City();
		destination.setName(destinationDTO.getName());
		destination.setCountry(destinationDTO.getCountry());

		a.getDestinations().add(destination);
		
		avioService.save(a);
		
		return new ResponseEntity<>(new CityDTO(destination), HttpStatus.CREATED);
		
	}
	
	

}
