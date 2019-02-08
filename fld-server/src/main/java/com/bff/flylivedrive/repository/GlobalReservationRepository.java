package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.FlightReservation;
import com.bff.flylivedrive.model.GlobalReservation;

public interface GlobalReservationRepository extends JpaRepository<GlobalReservation, Long> {
	

	GlobalReservation findOneById(Long id);


}
