package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.Seat;

public interface SeatRepository extends JpaRepository<Seat, Long>{
	
	Seat findOneById(Long id);

}
