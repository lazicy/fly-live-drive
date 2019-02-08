package com.bff.flylivedrive.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Flight;
import com.bff.flylivedrive.repository.FlightRepository;

@Service
public class FlightService {

	@Autowired
	FlightRepository flightRepo;
	
	public List<Flight> findAll() {
		return flightRepo.findAll();
	}
	
	public Flight findOneById(Long id) {
		return flightRepo.findOneById(id);
	}
	
	
	public Flight save(Flight f) {
		return flightRepo.save(f);
	}
	
	public List<Flight> getFlightByDate(Date date) {
		return flightRepo.getFlightByDate(date);
	}
	
	public List<Flight> getFlightByAvailableSeats(int availableSeats) {
		return flightRepo.getFlightByAvailableSeats(availableSeats);
	}
	
	public List<Flight> searchDepartureFlight(Long fromId, Long toId, Date depDate, int seats) {
		return flightRepo.searchDepartureFlight(fromId, toId, depDate, seats);
	}
	
	public List<Flight> searchReturnFlight(Long fromId, Long toId, Date depDate, Date retDate, int seats) {
		return flightRepo.searchReturnFlight(fromId, toId, depDate, retDate, seats);
	}
}
