package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.RentACar;

public class RentDTO {
	
	Long id;
	String name;
	String adress;
	String city;
	String country;
	String description;
	
	public RentDTO() {
		
	}
	
	public RentDTO(Long id, String name, String adress, String city, String country, String description) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.city = city;
		this.country = country;
		this.description = description;
	}

	public RentDTO(RentACar service) {
		this(service.getId(), service.getName(), service.getAdress(), service.getCity(), service.getCountry(), service.getDescription());
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

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
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
	
	
}
