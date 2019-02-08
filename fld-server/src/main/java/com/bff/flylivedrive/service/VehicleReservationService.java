package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.VehicleReservation;
import com.bff.flylivedrive.repository.VehicleReservationRepository;

@Service
public class VehicleReservationService {
	
	@Autowired
	VehicleReservationRepository vResRepo;
	
	public List<VehicleReservation> findAll(){
		return vResRepo.findAll();
	}
	
	
}
