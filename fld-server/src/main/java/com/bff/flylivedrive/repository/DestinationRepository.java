package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.Destination;

public interface DestinationRepository extends JpaRepository<Destination, Long>{
	
	Destination findOneById(Long id);
	

}
