package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bff.flylivedrive.model.Service;

public interface ServiceRepository extends JpaRepository<Service, Long>{
	
	Service findOneById(Long id);
	
}
