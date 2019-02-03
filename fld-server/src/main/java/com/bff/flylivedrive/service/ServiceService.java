package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.bff.flylivedrive.model.Service;
import com.bff.flylivedrive.repository.ServiceRepository;

public class ServiceService {
	
	@Autowired
	private ServiceRepository uslugaRepo;
	
	public Service findOneById(Long id) {
		return uslugaRepo.findOneById(id);
	}
	
	public List<Service> findAll() {
		return uslugaRepo.findAll();
	}
	
	public Service save(Service usluga) {
		// uslugaRepo.addInHotel(hotel_id, usluga.getId());
		return uslugaRepo.save(usluga);
	}
	
	public void remove(Long id) {
		uslugaRepo.deleteById(id);
	}
	
}
