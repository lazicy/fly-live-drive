package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bff.flylivedrive.model.Filijala;
import com.bff.flylivedrive.model.Vozilo;

public interface FilijalaRepository extends JpaRepository<Filijala, Long> {
	
	Filijala findOneById(Long id);
}
