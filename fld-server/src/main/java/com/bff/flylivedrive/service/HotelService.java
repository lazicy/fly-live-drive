package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
	
	//@Transactional
	public Hotel save (Hotel hotel) {
		return hotelRepo.save(hotel);
	}
	
	//@Transactional
	public void remove(Long id) {
		hotelRepo.deleteById(id);
	}
	
	public List<Hotel> findByName(String name) {
		return hotelRepo.findByName(name);
	}
	
	public List<Hotel> findByCity(Long id) {
		return hotelRepo.findByCity(id);
	}
	
	public List<Hotel> findByNameContainingIgnoreCase(String name) {
		return hotelRepo.findByNameContainingIgnoreCase(name);
	}
}
