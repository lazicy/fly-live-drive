package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.FlightReservation;
import com.bff.flylivedrive.model.Hotel;

public interface FlightReservationRepository extends JpaRepository<FlightReservation, Long>{
	
	FlightReservation findOneById(Long id);

}
