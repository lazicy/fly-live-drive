package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.Avio;
import com.bff.flylivedrive.repository.AvioRepository;


@Service
public class AvioService {

	@Autowired
	AvioRepository avioRepo;
	
	public Avio findOneById(Long id) {
		return avioRepo.findOneById(id);
	}
	
	public List<Avio> findAll() {
		return avioRepo.findAll();
	}
	
	public Avio save(Avio avio) {
		return avioRepo.save(avio);
	}
	
	public void remove(Long id) {
		avioRepo.deleteById(id);
	}
	
	
}
	