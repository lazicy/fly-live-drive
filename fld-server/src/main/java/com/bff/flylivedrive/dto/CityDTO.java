package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.City;

public class CityDTO {
	
	private Long id;
	private String name;
	private CountryDTO countryDTO;	
	
	
	public CityDTO() {
		
	}
	
	public CityDTO(City c) {
		this(c.getId(), c.getName(), null);
		
		setCountryDTO(new CountryDTO(c.getCountry().getId(), c.getCountry().getName()));
	}
	
	public CityDTO(Long id, String name, CountryDTO cDTO) {
		super();
		this.id = id;
		this.name = name;
		this.countryDTO = cDTO;
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

	public CountryDTO getCountryDTO() {
		return countryDTO;
	}

	public void setCountryDTO(CountryDTO countryDTO) {
		this.countryDTO = countryDTO;
	}
	
	

	
	
	
	
}
