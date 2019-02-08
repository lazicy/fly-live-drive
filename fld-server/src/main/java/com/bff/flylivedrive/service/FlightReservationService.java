package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.FlightReservation;
import com.bff.flylivedrive.repository.FlightReservationRepository;

@Service
public class FlightReservationService {

	@Autowired
	private FlightReservationRepository flightResRepo;
	
	public FlightReservation findOneById(Long id) {
		return flightResRepo.findOneById(id);
	}
	
	public List<FlightReservation> findAll(){
		return flightResRepo.findAll();
	}
	
	public FlightReservation save(FlightReservation fr) {
		return flightResRepo.save(fr);
	}
	public void deleteById(Long id) {
		flightResRepo.deleteById(id);
	}
}
