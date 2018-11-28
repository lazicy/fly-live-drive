package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.Filijala;
import com.bff.flylivedrive.repository.FilijalaRepository;

@Service
public class FilijalaService {
	
	@Autowired
	private FilijalaRepository fRepo;
	
	public Filijala findOneById(Long id) {
		return fRepo.findOneById(id);
	}
	
	public List<Filijala> findAll(){
		return fRepo.findAll();
	}
	
	public Filijala save(Filijala f) {
		return fRepo.save(f);
	}
}
