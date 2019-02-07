package com.bff.flylivedrive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.Hotel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface HotelRepository extends JpaRepository<Hotel, Long>{
	
	Hotel findOneById(Long id);
	
	@Query("select h from Hotel h where h.name = :hname")
	List<Hotel> searchHotels(@Param("hname") String name);
	
//	@Query("select f from Flight f, Destination fromDest, Destination toDest, City fromCity, City toCity "
//			+ "where fromCity.id = :fromId and toCity.id = :toId "
//			+ "and fromCity.id = fromDest.city.id and toCity.id = toDest.city.id "
//			+ "and fromDest.id = f.departureDestination.id and toDest.id = f.landingDestination.id "
//			+ "and f.availableSeats >= :seats "
//			+ "and f.departureDate >= :depDate")
//	List<Flight> searchDepartureFlight(@Param("fromId") Long fromId, @Param("toId") Long toId, @Param("depDate") Date depDate, @Param("seats") int seats);
}
