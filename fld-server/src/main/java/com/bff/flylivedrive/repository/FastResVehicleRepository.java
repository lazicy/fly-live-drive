package com.bff.flylivedrive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bff.flylivedrive.model.FastResVehicle;
import com.bff.flylivedrive.model.Filijala;

public interface FastResVehicleRepository extends JpaRepository<FastResVehicle, Long> {
	
	FastResVehicle findOneById(Long id);
	
	@Query("select distinct fr from Vozilo v, RentACar r,FastResVehicle fr where v.filijala.servis.id = :id and v.fastRes.id = fr.id")
	public List<FastResVehicle> getAllForRent(@Param("id") Long id);
	
}
