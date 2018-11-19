package com.bff.flylivedrive.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bff.flylivedrive.model.RentACar;

public interface RentRepository extends JpaRepository<RentACar, Long> {

}
