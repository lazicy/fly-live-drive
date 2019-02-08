package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bff.flylivedrive.dto.FlightReservationDTO;
import com.bff.flylivedrive.dto.SeatDTO;
import com.bff.flylivedrive.model.Flight;
import com.bff.flylivedrive.model.FlightReservation;
import com.bff.flylivedrive.model.GlobalReservation;
import com.bff.flylivedrive.model.Seat;
import com.bff.flylivedrive.model.User;
import com.bff.flylivedrive.service.FlightReservationService;
import com.bff.flylivedrive.service.FlightService;
import com.bff.flylivedrive.service.GlobalReservationService;
import com.bff.flylivedrive.service.UserService;

@RestController
@RequestMapping(value = "/flightreservation")
public class FlightReservationController {
	
	@Autowired
	FlightReservationService flightResService;
	@Autowired
	GlobalReservationService globalResService;
	@Autowired
	FlightService flightService;
	@Autowired
	UserService userService;
	
	// Get ALL flight reservations
	@RequestMapping(value="/all", method = RequestMethod.GET)
	public ResponseEntity<List<FlightReservationDTO>> getAllReservationsFlight(){
		
		
		List<FlightReservation> flightReservations = flightResService.findAll();
		List<FlightReservationDTO> flightReservationsDTO = new ArrayList<>();
		
		// konverzija u DTO
		for (FlightReservation fr: flightReservations) {
			String tripType = fr.getTripType();
			
			FlightReservationDTO frDTO;
			if (tripType.equals("round")) {
				frDTO = new FlightReservationDTO(fr);
			} else {
				frDTO = new FlightReservationDTO(fr, new Long(-1));
				
			}
			
			frDTO.setBonusPointsEarned(0);
		
			flightReservationsDTO.add(frDTO);
		}
		
		return new ResponseEntity<>(flightReservationsDTO, HttpStatus.OK);
	}
	
	
	// Get ONE flight reservation
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<FlightReservationDTO> getFlightReservation(@PathVariable Long id) {
		
		FlightReservation fr = flightResService.findOneById(id);
		
		if(fr == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		String tripType = fr.getTripType();
		
		FlightReservationDTO frDTO;
		if (tripType.equals("round")) {
			frDTO = new FlightReservationDTO(fr);
		} else {
			frDTO = new FlightReservationDTO(fr, new Long(-1));
			
		}
		
		frDTO.setBonusPointsEarned(0);
		
		
		return new ResponseEntity<>(frDTO, HttpStatus.OK);
	}
	

	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<FlightReservationDTO> saveFlightReservation(@RequestBody FlightReservationDTO frDTO) {
		
		String tripType = frDTO.getTripType();

		User u = userService.findOneByUsername(frDTO.getUsername());
		if (u == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		

		
		Flight depFlight = flightService.findOneById(frDTO.getDepartureFlightId());
		
		if (depFlight == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
	
		
		Flight retFlight = null;
		if (tripType.equals("round")) {
			retFlight = flightService.findOneById(frDTO.getReturnFlightId());
			
			if (retFlight == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
		}
		
		
		int earned;
		
		if (retFlight != null) {
			earned = calculateBonus(u, depFlight.getTotalDuration() + retFlight.getTotalDuration());
		} else {
			earned = calculateBonus(u, depFlight.getTotalDuration());
		}
	
		u.setBonus_points(u.getBonus_points() + earned);
		userService.save(u);
		
		FlightReservation fr = new FlightReservation();
		
	
		fr.setTripType(tripType);
		fr.setReservationDate(frDTO.getReservationDate());	
		fr.setDepartureFlight(depFlight);
		fr.setUsername(frDTO.getUsername());
		fr.setTotalPrice(frDTO.getTotalPrice());
		fr.setReturnFlight(retFlight);
	
		// form departure seats
		List<Seat> departureSeats = formSeats(frDTO.getDepartureSeatsDTO(), depFlight, fr, true);
		if (departureSeats == null || departureSeats.size() == 0) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		// form return seats
		List<Seat> returnSeats = new ArrayList<>();
		if (tripType.equals("round")) {
			returnSeats = formSeats(frDTO.getReturnSeatsDTO(), retFlight, fr, false);
			if (returnSeats == null || returnSeats.size() == 0) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			
			// check if return after departing
			if(depFlight.getLandingDate().after(retFlight.getDepartureDate())) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		}
		
		fr.setDepartureSeats(departureSeats);
		fr.setReturnSeats(returnSeats);
		
		flightService.save(depFlight);

		if (tripType.equals("round")) {
			flightService.save(retFlight);
		}
		
		
		System.out.println("Znaci doso dovde.");
		fr = flightResService.save(fr);
		
		// creating GlobalReservationObject
		GlobalReservation gr = new GlobalReservation();
		// setovanje na aktiv
		gr.setActive(true);
		gr.setFlightReservation(fr);
		
		gr = globalResService.save(gr);
		
		fr.setGlobalReservation(gr);

		fr = flightResService.save(fr);
		
		FlightReservationDTO frDTOret;
		
		if (tripType.equals("round")) {
			frDTOret = new FlightReservationDTO(fr);
		} else {
			frDTOret = new FlightReservationDTO(fr, new Long(-1));
			
		}
		
		frDTOret.setBonusPointsEarned(earned);
		
		return new ResponseEntity<>(frDTOret, HttpStatus.CREATED);
			
	}
	
	private List<Seat> formSeats(List<SeatDTO> seatsDTO, Flight f, FlightReservation fr, boolean departure) {
		// temorary, null je indikator greske, znam, jako odvratno i sramotno
		List<Seat> retVal = new ArrayList<>();
		for (SeatDTO sDTO: seatsDTO) {
			for (Seat s: f.getSeats()) {

		
				
				if (s.getId().equals(sDTO.getId())) {

					// ukoliko je rezervisano sediste ili ih nema vise, moraju oba biti tacna u sustini
					if(s.isReserved() || f.getAvailableSeats() == 0) {
						return null;
					} else {
						
						s.setReserved(true);
						if (departure) {
							s.setReservationDeparture(fr);
						} else {
							s.setReservationReturn(fr);
						}
						
						// dekrementiraj sedista
						f.setAvailableSeats(f.getAvailableSeats()-1);
						retVal.add(s);
						System.out.println("Reserved seat no: " + s.getId());
					}
				}
			}
		}
		
		return retVal;
		
		
	}
	
	private int calculateBonus(User u, int duration) {
		
		int bonus;
		if (duration >= 60 && duration < 240) {
			bonus = 1;
		} else if (duration >= 240 && duration < 360) {
			bonus = 2;
		} else if (duration >= 360 && duration < 600) {
			bonus = 3;
		} else if (duration >= 600){
			bonus = 4;
		} else {
			bonus = 0;
		}
		
		int earned = 0;
		if (bonus + u.getBonus_points() >= 15) {
			earned = 15 - u.getBonus_points();
		} else {
			earned = bonus;
		}
		
		
		return earned;
		
		
	}
	
	
}
