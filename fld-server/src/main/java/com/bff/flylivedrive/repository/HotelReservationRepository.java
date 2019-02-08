package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import com.bff.flylivedrive.model.HotelReservation;

public interface HotelReservationRepository extends JpaRepository<HotelReservation, Long> {
	
	HotelReservation findOneById(Long id);
	
	@Modifying
	@Query(value = "insert into hotel_res_services (hotel_res_id, service_id) values (?1, ?2)", nativeQuery = true)
	void addServices(Long hotel_res_id, Long service_id);
}
