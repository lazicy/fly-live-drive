package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.HotelReservation;

public interface HotelReservationRepository extends JpaRepository<HotelReservation, Long> {
	
	HotelReservation findOneById(Long id);
	
}
