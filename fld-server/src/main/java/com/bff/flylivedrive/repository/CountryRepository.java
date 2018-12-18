package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{
	
	Country findOneById(Long id);

}
