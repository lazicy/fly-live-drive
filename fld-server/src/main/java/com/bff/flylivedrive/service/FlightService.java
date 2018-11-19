package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
