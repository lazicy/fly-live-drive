package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bff.flylivedrive.model.Usluga;

public interface ServiceRepository extends JpaRepository<Usluga, Long>{
	
	Usluga findOneById(Long id);
	
}
