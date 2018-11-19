package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
	
	Flight findOneById(Long id);

}
