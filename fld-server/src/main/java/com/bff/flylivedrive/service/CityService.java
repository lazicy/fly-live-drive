package com.bff.flylivedrive.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.repository.CityRepository;

@Service
public class CityService {
	
	@Autowired
	CityRepository cityRepo;
	
	public City findOneById(Long id) {
		return cityRepo.findOneById(id);
	}
	
	public List<City> findAll() {
		return cityRepo.findAll();
	}
	
	public List<City> findCityByCountryId(Long id){
		return cityRepo.findCityByCountryId(id);
	}
	
	public City findOneByName(String name){
		return cityRepo.findOneByName(name);
	}
	
	public List<City> findByName(String name) {
		return cityRepo.findByName(name);
	}
	
	public List<City> findByNameContainingIgnoreCase(String name) {
		return cityRepo.findByNameContainingIgnoreCase(name);
	}
}
