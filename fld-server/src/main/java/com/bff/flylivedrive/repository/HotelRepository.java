package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.Hotel;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
	
	Hotel findOneById(Long id);
	
}
