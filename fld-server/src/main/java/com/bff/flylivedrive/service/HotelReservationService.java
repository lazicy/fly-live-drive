package com.bff.flylivedrive.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.HotelReservation;
import com.bff.flylivedrive.repository.HotelReservationRepository;

@Service
public class HotelReservationService {
	
	@Autowired
	HotelReservationRepository rezRepo;
	
	public HotelReservation findOneById(Long id) {
		return rezRepo.findOneById(id);
	}
	
	
	public HotelReservation save (HotelReservation rez) {
		return rezRepo.save(rez);
	}
	
}
