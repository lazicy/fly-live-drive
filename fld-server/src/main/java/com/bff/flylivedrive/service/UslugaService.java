package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.Usluga;
import com.bff.flylivedrive.repository.ServiceRepository;

@Service
public class UslugaService {
	
	@Autowired
	private ServiceRepository uslugaRepo;
	
	public Usluga findOneById(Long id) {
		return uslugaRepo.findOneById(id);
	}
	
	public List<Usluga> findAll() {
		return uslugaRepo.findAll();
	}
	
	public Usluga save(Usluga usluga) {
		return uslugaRepo.save(usluga);
	}
	
	public void remove(Long id) {
		uslugaRepo.deleteById(id);
	}
	
}
