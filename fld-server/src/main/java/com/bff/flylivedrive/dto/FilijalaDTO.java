package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Filijala;

public class FilijalaDTO {
	
	private Long id;
	private String name;
	private String address;
	private String city;
	private String country;
	private String description;
	
	public FilijalaDTO() {
		
	}

	public FilijalaDTO(Filijala f) {
		this(f.getId(),f.getName(),f.getAddress(),f.getCity(),f.getCountry(),f.getDescription());
	}
	
	public FilijalaDTO(Long id, String name, String adress, String city, String country, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = adress;
		this.city = city;
		this.country = country;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
