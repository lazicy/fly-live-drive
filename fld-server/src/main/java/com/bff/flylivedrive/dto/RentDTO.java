package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.RentACar;

public class RentDTO {
	
	Long id;
	String name;
	String address;
	String city;
	String country;
	String description;
	String rentImageUrl;
	
	public RentDTO() {
		
	}
	
	public RentDTO(Long id, String name, String adress, String city, String country, String description,String rentImageUrl) {
		super();
		this.id = id;
		this.name = name;
		this.address = adress;
		this.city = city;
		this.country = country;
		this.description = description;
		this.rentImageUrl = rentImageUrl;
	}

	public RentDTO(RentACar service) {
		this(service.getId(), service.getName(), service.getAddress(), service.getCity(), service.getCountry(), service.getDescription(),service.getRentImageUrl());
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

	public String getRentImageUrl() {
		return rentImageUrl;
	}

	public void setRentImageUrl(String rentImageUrl) {
		this.rentImageUrl = rentImageUrl;
	}
	
	
}
