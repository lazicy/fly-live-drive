package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.Vozilo;
import com.bff.flylivedrive.repository.VoziloRepository;

@Service
public class VoziloService {
	
	@Autowired
	private VoziloRepository voziloRepo;
	
	public Vozilo findOneById(Long id) {
		return voziloRepo.findOneById(id);
	}
	
	public List<Vozilo> findAll(){
		return voziloRepo.findAll();
	}
	
	public Vozilo save(Vozilo v) {
		return voziloRepo.save(v);
	}
}
