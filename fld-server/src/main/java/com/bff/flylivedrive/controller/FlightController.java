package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bff.flylivedrive.dto.FlightDTO;
import com.bff.flylivedrive.dto.InterceptionDTO;
import com.bff.flylivedrive.dto.SearchFlightDTO;
import com.bff.flylivedrive.dto.SearchFlightResultDTO;
import com.bff.flylivedrive.dto.SeatDTO;
import com.bff.flylivedrive.dto.mappers.FlightMapper;
import com.bff.flylivedrive.dto.mappers.InterceptionMapper;
import com.bff.flylivedrive.model.Avio;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Destination;
import com.bff.flylivedrive.model.Flight;
import com.bff.flylivedrive.model.Interception;
import com.bff.flylivedrive.model.Seat;
import com.bff.flylivedrive.service.AvioService;
import com.bff.flylivedrive.service.CityService;
import com.bff.flylivedrive.service.FlightService;
import com.bff.flylivedrive.service.SeatService;

@RestController
@RequestMapping(value = "/flight")
public class FlightController {
	
	@Autowired
	FlightService flightService;
	@Autowired
	AvioService avioService;
	@Autowired
	CityService cityService;
	@Autowired
	SeatService seatService;

	// Get ALL flights of ALL avios
	@RequestMapping(value="/all", method = RequestMethod.GET)
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
	
	// Get ONE flight's seats
	@RequestMapping(value="/{id}/seats", method=RequestMethod.GET)
	public ResponseEntity<List<SeatDTO>> getFlightSeats(@PathVariable Long id) {
		
		Flight flight = flightService.findOneById(id);
		
		if(flight == null){
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<SeatDTO> seatsDTO = new ArrayList<>();
		
	
		for (Seat s: flight.getSeats()) {
			seatsDTO.add(new SeatDTO(s));
		}
		
		return new ResponseEntity<>(seatsDTO, HttpStatus.OK);
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
		
		
		Set<Destination> destinations = a.getDestinations();
		Destination departureDest = null;
		Destination landingDest = null;
		
		for (Destination d: destinations) {
			
			if (d.getCity().getId() == flightDTO.getDepartureDestination().getCityDTO().getId()) {
				departureDest = d;
			}
			
			if (d.getCity().getId() == flightDTO.getLandingDestination().getCityDTO().getId()) {
				landingDest = d;
			}
		}
		
		// if one of them is still null or both are equal  - bad request
		if (landingDest == null || departureDest == null || departureDest.getCity().getId() == landingDest.getCity().getId()) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		// map flight [interceptions will be set latter because they need flight reference]
		FlightMapper mapper = new FlightMapper();
		Flight flight = mapper.map(flightDTO, a, departureDest, landingDest);
		
		// form and map all interceptions 
		Set<Interception> interceptions = formInterceptionsSet(flightDTO.getInterceptionsDTO(), flight, destinations);
		
		if (interceptions == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		flight.setInterceptions(interceptions);
		
		// form seats (and set them to false)
		List<Seat> seats = formSeatList(flightDTO.getNumberOfSeats(), flight);
		
		flight.setSeats(seats);
		flight.setAvailableSeats(flightDTO.getNumberOfSeats());
		flight.setDiscountSeats(0);
		
		// save to database
		flight = flightService.save(flight);
		
		return new ResponseEntity<>(new FlightDTO(flight), HttpStatus.CREATED);
		
	}
	
	@RequestMapping(value ="/search", method = RequestMethod.POST, consumes = "application/json")
	private ResponseEntity<SearchFlightResultDTO> searchFlights(@RequestBody SearchFlightDTO sfDTO) {
		
		
		System.out.println(sfDTO.getDepartureDate());
		System.out.println(sfDTO.getReturnDate());
		System.out.println(sfDTO.getFromCity());
		System.out.println(sfDTO.getToCity());
		System.out.println(sfDTO.getNumberOfPeople());
		System.out.println(sfDTO.getTripType());
		
		
		// pronadji u bazi gradove, moraju biti unesena oba, ukoliko nisu oba unesena vrati bad_request
		City fromCity = cityService.findOneById(sfDTO.getFromCity().getId());
		City toCity = cityService.findOneById(sfDTO.getToCity().getId());
		
		if (fromCity == null || toCity == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		List<Flight> departureFlights = new ArrayList<>();
		departureFlights = flightService.searchDepartureFlight(fromCity.getId(), toCity.getId(), sfDTO.getDepartureDate(), sfDTO.getNumberOfPeople());
		
		List<Flight> returnFlights = new ArrayList<>();
		if (sfDTO.getTripType().equals("round")) {
			
			returnFlights = flightService.searchReturnFlight(toCity.getId(), fromCity.getId(), sfDTO.getDepartureDate(),
					sfDTO.getReturnDate(), sfDTO.getNumberOfPeople());

		}
		
		System.out.println("DEPARTURE FLIGHTS");
		List<FlightDTO> departureFlightsDTO = new ArrayList<>();
		for (Flight f: departureFlights) {
			
			System.out.println(f.toString());
			departureFlightsDTO.add(new FlightDTO(f));
		}
		
		System.out.println("------------------");
		
		System.out.println("RETURN FLIGHTS");

		List<FlightDTO> returnFlightsDTO = new ArrayList<>();
		
		for (Flight f: returnFlights) {
			returnFlightsDTO.add(new FlightDTO(f));
		}
		
		
		SearchFlightResultDTO resultsRet = new SearchFlightResultDTO(departureFlightsDTO, returnFlightsDTO, sfDTO.getTripType());
		
		return new ResponseEntity<>(resultsRet, HttpStatus.OK);
	}
	
	
	@RequestMapping(value ="/{id}/delete", method = RequestMethod.PUT, consumes = "application/json")
	private ResponseEntity<SeatDTO> deleteSeats(@RequestBody List<SeatDTO> seatsDTO, @PathVariable Long flightId) {
		
		Flight f = flightService.findOneById(flightId);
		if (f == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		for (SeatDTO sDTO: seatsDTO) {
			Seat s = seatService.findOneById(sDTO.getId());
			if (s == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			if (s.isReserved()) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			s.setDeleted(true);
			seatService.save(s);
		}
		
		f.setAvailableSeats(f.getAvailableSeats() - seatsDTO.size());
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value ="/{id}/discount", method = RequestMethod.PUT, consumes = "application/json")
	private ResponseEntity<SeatDTO> discountSeats(@RequestBody List<SeatDTO> seatsDTO, @PathVariable Long flightId) {
		

		Flight f = flightService.findOneById(flightId);
		if (f == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		for (SeatDTO sDTO: seatsDTO) {
			Seat s = seatService.findOneById(sDTO.getId());
			if (s == null) {
				return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
			
			if (s.isReserved() || s.isDeleted()) {
				return new ResponseEntity<>(HttpStatus.CONFLICT);
			}
			
			s.setDiscount(sDTO.getDiscount());
			seatService.save(s);
		}
		

		f.setAvailableSeats(f.getAvailableSeats() - seatsDTO.size());
		f.setDiscountSeats(seatsDTO.size());
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	
	
	
	
	// forming set of interceptions
	private Set<Interception> formInterceptionsSet(List<InterceptionDTO> interceptionsDTO, Flight f, Set<Destination> destinations) {
		Set<Interception> interceptions = new HashSet<>();
		for (InterceptionDTO iDTO: interceptionsDTO) {
			
			Destination destination = null;
			
			for (Destination d: destinations) {
				
				if (iDTO.getDestinationDTO().getCityDTO().getId() == d.getCity().getId()) {
					destination = d;
					break;
				}
			}
			
			// return null if there isn't any 
			if (destination == null) {
				return null;
			}
			
			InterceptionMapper mapper = new InterceptionMapper();
			Interception i = new Interception();
			i = mapper.map(iDTO, destination, f);
			
			// finaly put it in set
			interceptions.add(i);
			
		}
		
		return interceptions;
		
		
	}
	
	private List<Seat> formSeatList(int numberOfSeats, Flight f) {
		
		List<Seat> seats = new ArrayList<>();
		int row = 0;
		
		for (int i = 0; i < numberOfSeats; i++) {
			Seat s = new Seat();
			s.setFlight(f);
			s.setReserved(false);
			s.setDiscount(0);
			s.setDeleted(false);
			seats.add(s);
			
			int ostatak = i % 6;
			
			if (ostatak == 0) {
				row++;
				s.setRow(row);
				s.setPlace("A");
			} else if (ostatak == 1) {
				s.setRow(row);
				s.setPlace("B");
			} else if (ostatak == 2) {
				s.setRow(row);
				s.setPlace("C");
			}  else if (ostatak == 3) {
				s.setRow(row);
				s.setPlace("D");
			}  else if (ostatak == 4) {
				s.setRow(row);
				s.setPlace("E");
			}  else if (ostatak == 5) {
				s.setRow(row);
				s.setPlace("F");
			}  
			
		}
		
		return seats;
	}
	
	

}
