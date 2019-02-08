package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.FlightReservation;
import com.bff.flylivedrive.model.GlobalReservation;
import com.bff.flylivedrive.repository.GlobalReservationRepository;

@Service
public class GlobalReservationService {
	
	@Autowired
	private GlobalReservationRepository globalResRepo;
	
	public GlobalReservation findOneById(Long id) {
		return globalResRepo.findOneById(id);
	}
	
	public List<GlobalReservation> findAll(){
		return globalResRepo.findAll();
	}
	
	public GlobalReservation save(GlobalReservation gr) {
		return globalResRepo.save(gr);
	}
	public void deleteById(Long id) {
		globalResRepo.deleteById(id);
	}

}
