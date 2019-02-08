package com.bff.flylivedrive.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bff.flylivedrive.dto.FlightReservationDTO;
import com.bff.flylivedrive.dto.GlobalReservationDTO;
import com.bff.flylivedrive.model.GlobalReservation;
import com.bff.flylivedrive.service.FlightReservationService;
import com.bff.flylivedrive.service.GlobalReservationService;

@RestController
@RequestMapping(value = "/globalreservation")
public class GlobalReservationController {
	
	@Autowired
	GlobalReservationService globalResService;
	
	@Autowired
	FlightReservationService flightResService;
	
	
	// Get ONE global reservation
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<GlobalReservationDTO> getGlobalReservation(@PathVariable Long id) {
		
		GlobalReservation gr = globalResService.findOneById(id);
		
		if(gr == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		return new ResponseEntity<>(new GlobalReservationDTO(gr), HttpStatus.OK);
	}
	
	
	// TODO napisati i ostale metode koje ce omoguciti da se kace objekti renta i hotela

}
