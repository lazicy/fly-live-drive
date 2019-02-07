package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.VehicleReservation;

public interface VehicleReservationRepository extends JpaRepository<VehicleReservation, Long> {
	VehicleReservation findOneById(Long id);
	
}
