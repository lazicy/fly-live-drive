package com.bff.flylivedrive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.Hotel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
	
	Hotel findOneById(Long id);
	
	@Query("select h from Hotel h where h.name = :name")
	List<Hotel> findByName(@Param("name") String name);
	
	@Query("select h from Hotel h where h.city.id = :id")
	List<Hotel> findByCity(@Param("id") Long id);
	
	List<Hotel> findByNameContainingIgnoreCase(String username);
}
