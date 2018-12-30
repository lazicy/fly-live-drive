package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.RentACar;
import com.bff.flylivedrive.model.Vozilo;

public interface RentRepository extends JpaRepository<RentACar, Long> {
	
	RentACar findOneById(Long id);
	void deleteById(Long id);
	//String Q_GET_ALL_BRANCHES = "select branch from filijale left join rentacar on servs_id = id";
}
