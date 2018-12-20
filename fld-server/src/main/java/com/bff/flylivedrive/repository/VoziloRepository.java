package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.RentAdmin;
import com.bff.flylivedrive.model.Vozilo;

public interface VoziloRepository extends JpaRepository<Vozilo, Long> {
	
	Vozilo findOneById(Long id);
	
}
