package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.Country;
import com.bff.flylivedrive.repository.CountryRepository;

@Service
public class CountryService {
	
	@Autowired
	CountryRepository countryRepo;
	
	public Country findOneById(Long id) {
		return countryRepo.findOneById(id);
	}
	
	public List<Country> findAll() {
		return countryRepo.findAll();
	}
	
	public Country save(Country c) {
		return countryRepo.save(c);
	}
	
	public void remove(Long id) {
		countryRepo.deleteById(id);
	}

}
