package com.bff.flylivedrive.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Flight;

public interface FlightRepository extends JpaRepository<Flight, Long>{
	
	Flight findOneById(Long id);
	
	@Query("select f from Flight f where f.departureDate >= :date")
	List<Flight> getFlightByDate(@Param("date") Date date);
	
	@Query("select f from Flight f where f.availableSeats >= :availableSeats")
	List<Flight> getFlightByAvailableSeats(@Param("availableSeats") int availableSeats);
	
	@Query("select f from Flight f, Destination fromDest, Destination toDest, City fromCity, City toCity "
			+ "where fromCity.id = :fromId and toCity.id = :toId "
			+ "and fromCity.id = fromDest.city.id and toCity.id = toDest.city.id "
			+ "and fromDest.id = f.departureDestination.id and toDest.id = f.landingDestination.id "
			+ "and f.availableSeats >= :seats "
			+ "and f.departureDate >= :depDate")
	List<Flight> searchDepartureFlight(@Param("fromId") Long fromId, @Param("toId") Long toId, @Param("depDate") Date depDate, @Param("seats") int seats);
	
	
	
	@Query("select f from Flight f, Destination fromDest, Destination toDest, City fromCity, City toCity "
			+ "where fromCity.id = :fromId and toCity.id = :toId "
			+ "and fromCity.id = fromDest.city.id and toCity.id = toDest.city.id "
			+ "and fromDest.id = f.departureDestination.id and toDest.id = f.landingDestination.id "
			+ "and f.availableSeats >= :seats "
			+ "and f.departureDate >= :depDate and f.departureDate <= :retDate")
	List<Flight> searchReturnFlight(@Param("fromId") Long fromId, @Param("toId") Long toId,
			@Param("depDate") Date depDate, @Param("retDate") Date retDate, @Param("seats") int seats);

}
