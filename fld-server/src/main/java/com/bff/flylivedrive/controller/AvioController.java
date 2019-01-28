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
import com.bff.flylivedrive.dto.DestinationDTO;
import com.bff.flylivedrive.dto.FlightDTO;
import com.bff.flylivedrive.dto.mappers.AvioMapper;
import com.bff.flylivedrive.model.Avio;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Destination;
import com.bff.flylivedrive.model.Flight;
import com.bff.flylivedrive.service.AvioService;
import com.bff.flylivedrive.service.CityService;

@RestController
@RequestMapping(value = "/avio")
public class AvioController {
	
	@Autowired
	AvioService avioService;
	
	@Autowired
	CityService cityService;
	
	// Get ALL avio
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<AvioDTO>> getAllAvios(){
		
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
	
	// Get ONE avio
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<AvioDTO> getAvio(@PathVariable Long id) {
		
		Avio avio = avioService.findOneById(id);
		
		if(avio == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new AvioDTO(avio), HttpStatus.OK);
	}
	
	// Delete ONE avio
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAvio(@PathVariable Long id){
		
		Avio avio = avioService.findOneById(id);
		
		if (avio != null){
			avioService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {		
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	

	// Post ONE avio
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<AvioDTO> saveAvio(@RequestBody AvioDTO avioDTO) {
		
		City c = cityService.findOneById(avioDTO.getCityDTO().getId());
		
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		AvioMapper mapper = new AvioMapper();
		Avio avio = mapper.map(avioDTO, c);
		
		
		
		avio = avioService.save(avio);
		
		return new ResponseEntity<>(new AvioDTO(avio), HttpStatus.CREATED);
		
	}
	
	// Get ALL flights for ONE avio
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
	
	// Get ALL destinations from ONE avio
	@RequestMapping(value = "/{avioId}/destinations", method = RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> getAviosDestinations(@PathVariable Long avioId) {

		Avio avio = avioService.findOneById(avioId);
		Set<Destination> destinations = avio.getDestinations();
		List<CityDTO> destinationCitiesDTO = new ArrayList<>();
		
		for (Destination d : destinations) {
			
			CityDTO dDTO = new CityDTO(d.getCity());
			destinationCitiesDTO.add(dDTO);
		}
		
		return new ResponseEntity<>(destinationCitiesDTO, HttpStatus.OK); 
		
	}
	
	
	@RequestMapping(value = "/destinations", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<CityDTO> saveDestination(@RequestBody DestinationDTO destinationDTO) {
		
		
		
		Avio a = avioService.findOneById(destinationDTO.getAvioId());
		System.out.println(a);
		if (a == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		
		Set<Destination> destinations = a.getDestinations();
				
		for (Destination d: destinations) {
			City c = d.getCity();
			
			if (c.getId() == destinationDTO.getCityDTO().getId()) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		
		City c = cityService.findOneById(destinationDTO.getCityDTO().getId());
		if (c == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		Destination destination = new Destination();
		destination.setAvio(a);
		destination.setCity(c);
		
		destinations.add(destination);
		
		avioService.save(a);
		
		return new ResponseEntity<>(new CityDTO(destination.getCity()), HttpStatus.CREATED);
		
	}
	
	
	

}
