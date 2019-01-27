package com.bff.flylivedrive.dto;

import java.util.ArrayList;
import java.util.List;

import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Country;

public class CountryDTO {
	
	private Long id;
	private String name;
	
	public CountryDTO() {
		
	}

	public CountryDTO(Country c) {
		this(c.getId(), c.getName());
		
	}
	
	public CountryDTO(Long id, String name) {
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
