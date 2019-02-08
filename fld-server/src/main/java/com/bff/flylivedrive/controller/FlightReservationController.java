package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bff.flylivedrive.dto.FlightReservationDTO;
import com.bff.flylivedrive.dto.SeatDTO;
import com.bff.flylivedrive.model.Flight;
import com.bff.flylivedrive.model.FlightReservation;
import com.bff.flylivedrive.model.Seat;
import com.bff.flylivedrive.service.FlightReservationService;
import com.bff.flylivedrive.service.FlightService;

@RestController
@RequestMapping(value = "/flightreservation")
public class FlightReservationController {
	
	@Autowired
	FlightReservationService flightResService;
	@Autowired
	FlightService flightService;
	
	// Get ALL flight reservations
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<FlightReservationDTO>> getAllReservationsFlight(){
		

		
		List<FlightReservation> flightReservations = flightResService.findAll();
		List<FlightReservationDTO> flightReservationsDTO = new ArrayList<>();
		
		// konverzija u DTO
		for (FlightReservation fr: flightReservations) {
			FlightReservationDTO frDTO = new FlightReservationDTO(fr);
			flightReservationsDTO.add(frDTO);
		}
		
		return new ResponseEntity<>(flightReservationsDTO, HttpStatus.OK);
	}
	
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<FlightReservationDTO> saveFlightReservation(@RequestBody FlightReservationDTO frDTO) {
	
	String tripType = frDTO.getTripType();
	
	
	Flight depFlight = flightService.findOneById(frDTO.getDepartureFlightId());
	
	if (depFlight == null) {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	boolean departureSeatsOK = checkIfAllSeatsAvailable(frDTO.getDepartureSeatsDTO());
	boolean returnSeatsOK = false;
	// TODO Dodatni checkovi da se ne moze rezervisati let kad je vec poleteo
	
	
	Flight retFlight = null;
	if (tripType.equals("round")) {
		retFlight = flightService.findOneById(frDTO.getReturnFlightId());
		
		if (retFlight == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		returnSeatsOK = checkIfAllSeatsAvailable(frDTO.getDepartureSeatsDTO());
	}
	

	FlightReservation fr = new FlightReservation();
	if (departureSeatsOK) {

		fr.setTripType(tripType);
		fr.setReservationDate(fr.getReservationDate());	
		fr.setDepartureFlight(depFlight);
		fr.setUsername(frDTO.getUsername());
		fr.setTotalPrice(frDTO.getTotalPrice());
		fr.setReturnFlight(retFlight);
		fr.setDepartureSeats(formSeats(frDTO.getDepartureSeatsDTO(), depFlight));
		
		if (tripType.equals("round")) {
			if (!returnSeatsOK) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			} else {
				fr.setReturnSeats(formSeats(frDTO.getReturnSeatsDTO(), retFlight));
			}
		} else {
			fr.setReturnSeats(new ArrayList<Seat>());
		}
		
		
	} else {
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
	}
	
	fr = flightResService.save(fr);
	
	FlightReservationDTO frDTOret;
	
	if (tripType.equals("round")) {
		frDTOret = new FlightReservationDTO(fr);
	} else {
		frDTOret = new FlightReservationDTO(fr, new Long(-1));
		
	}
		
	return new ResponseEntity<>(frDTOret, HttpStatus.CREATED);
		
	}
	
	private List<Seat> formSeats(List<SeatDTO> seatsDTO, Flight f) {
		// temorary
		List<Seat> retVal = new ArrayList<>();
		for (SeatDTO sDTO: seatsDTO) {
			for (Seat s: f.getSeats()) {
				if (s.getId() == sDTO.getId()) {
					if(s.isReserved()) {
						return null;
					} else {
						s.setReserved(true);
						retVal.add(s);
					}
				}
			}
		}
		
		return retVal;
		
		
	}
	
	private boolean checkIfAllSeatsAvailable(List<SeatDTO> seatsDTO) {
		// TODO IMPLEMENT
		return true;
	}

}
