package com.bff.flylivedrive.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Country;
import com.bff.flylivedrive.model.RentACar;
import com.bff.flylivedrive.model.Vozilo;

public interface RentRepository extends JpaRepository<RentACar, Long> {
	RentACar findOneById(Long id);
	void deleteById(Long id);
	
	
}
