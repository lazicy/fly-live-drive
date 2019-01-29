package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.Destination;
import com.bff.flylivedrive.repository.DestinationRepository;

@Service
public class DestinationService {
	
	@Autowired
	private DestinationRepository destRepo;
	
	public Destination findOneById(Long id) {
		return	destRepo.findOneById(id);
	}
	
	public List<Destination> findAll(){
		return destRepo.findAll();
	}
	
	public Destination save(Destination d) {
		return destRepo.save(d);
	}
	
	public void deleteById(Long id) {
		destRepo.deleteById(id);
	}
}
