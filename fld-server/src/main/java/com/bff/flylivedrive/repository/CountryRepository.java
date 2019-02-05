package com.bff.flylivedrive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bff.flylivedrive.model.Country;

public interface CountryRepository extends JpaRepository<Country, Long>{
	
	Country findOneById(Long id);
	
	@Query("select distinct country from RentACar rent,Filijala f, Country country, City city where rent.id = :id and rent.id = f.servis.id and f.city.id = city.id and city.country.id = country.id")
    public List<Country> getRentCountries(@Param("id") Long id);
}
