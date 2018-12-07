package com.bff.flylivedrive.dto;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import com.bff.flylivedrive.model.Avio;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Interception;

public class AvioDTO {
	
	private Long id;
	private String name;
	private String description;
	
	
	public AvioDTO() {
		
	}
	
	public AvioDTO(Avio a) {
		this(a.getId(), a.getName(), a.getDescription());
	}
	
	public AvioDTO(Long id, String name, String description) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
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

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
