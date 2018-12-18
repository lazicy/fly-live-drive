package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.City;

public class CityDTO {
	
	private Long id;
	private String name;
	
	
	public CityDTO() {
		
	}
	
	public CityDTO(City c) {
		this(c.getId(), c.getName());
	}
	
	public CityDTO(Long id, String name) {
		super();
		this.id = id;
		this.name = name;
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

	
	
	
	
}
