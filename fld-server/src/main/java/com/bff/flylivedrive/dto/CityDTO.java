package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.City;

public class CityDTO {
	
	private Long id;
	private String name;
	private String country;
	
	
	public CityDTO() {
		
	}
	
	public CityDTO(City c) {
		this(c.getId(), c.getName(), c.getCountry());
	}
	
	public CityDTO(Long id, String name, String country) {
		super();
		this.id = id;
		this.name = name;
		this.country = country;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	
	
	
}
