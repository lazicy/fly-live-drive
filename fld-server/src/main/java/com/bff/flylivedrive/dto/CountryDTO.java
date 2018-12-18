package com.bff.flylivedrive.dto;

import java.util.ArrayList;
import java.util.List;

import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Country;

public class CountryDTO {
	
	private Long id;
	private String name;
	private List<CityDTO> citiesDTO;
	
	
	
	public CountryDTO() {
		
	}

	public CountryDTO(Country c) {
		this(c.getId(), c.getName(), null);
		
		// forming dto
		List<CityDTO> citiesDTO = new ArrayList<>();
		
		for (City city : c.getCites()) {
			citiesDTO.add(new CityDTO(city));
		}
		
		//setting dto
		this.citiesDTO = citiesDTO;
	}
	
	public CountryDTO(Long id, String name, List<CityDTO> citiesDTO) {
		super();
		this.id = id;
		this.name = name;
		this.citiesDTO = citiesDTO;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<CityDTO> getCitiesDTO() {
		return citiesDTO;
	}

	public void setCitiesDTO(List<CityDTO> citiesDTO) {
		this.citiesDTO = citiesDTO;
	}

	

	
	
}
