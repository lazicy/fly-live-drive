package com.bff.flylivedrive.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.Filijala;
import com.bff.flylivedrive.model.Seat;
import com.bff.flylivedrive.repository.SeatRepository;

@Service
public class SeatService {
	
	@Autowired
	SeatRepository seatRepo;
	

	public Seat findOneById(Long id) {
		return seatRepo.findOneById(id);
	}
	
	public Seat save(Seat s) {
		return seatRepo.save(s);
	}
}
