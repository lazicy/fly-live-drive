package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.RentACar;
import com.bff.flylivedrive.repository.RentRepository;

@Service
public class RentService {

	@Autowired
	private RentRepository rentRepo;
	
	public RentACar findOneById(Long id) {
		return rentRepo.findOneById(id);
	}
	
	public List<RentACar> findAll(){
		return rentRepo.findAll();
	}
	
	public RentACar save(RentACar service) {
		return rentRepo.save(service);
	}

}