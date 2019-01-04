package com.bff.flylivedrive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.Hotel;

import org.springframework.data.jpa.repository.Query;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
	
	Hotel findOneById(Long id);
	
	@Query("select h from Hotel h where (h.name = ?1 or h.city = ?1)")
	List<Hotel> searchHotels(String name);
}
