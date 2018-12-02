package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.Hotel;
import com.bff.flylivedrive.repository.HotelRepository;

@Service
public class HotelService {
	
	@Autowired
	HotelRepository hotelRepo;
	
	public Hotel findOneById(Long id) {
		return hotelRepo.findOneById(id);
	}
	
	public List<Hotel> findAll() {
		return hotelRepo.findAll();
	}
	
	public Hotel save (Hotel hotel) {
		return hotelRepo.save(hotel);
	}
	
	public void remove(Long id) {
		hotelRepo.deleteById(id);
	}
}
