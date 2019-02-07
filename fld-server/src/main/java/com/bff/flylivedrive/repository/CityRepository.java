package com.bff.flylivedrive.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.bff.flylivedrive.model.City;

public interface CityRepository extends JpaRepository<City, Long>{
	
	City findOneById(Long id);
	City findOneByName(String name);
	
	@Query("select city from City city, Country country where country.id = city.country.id and country.id = :id")
	public List<City> findCityByCountryId(@Param("id") Long id);

}
