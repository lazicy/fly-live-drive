package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.City;

public interface CityRepository extends JpaRepository<City, Long>{
	
	City findOneById(Long id);

}
