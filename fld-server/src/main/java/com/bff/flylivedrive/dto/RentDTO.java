package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.RentACar;

public class RentDTO {
	
	Long id;
	String name;
	String address;
	CityDTO cityDTO;
	String description;
	
	public RentDTO() {
		
	}
	
	public RentDTO(Long id, String name, String adress, CityDTO cityDTO, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = adress;
		this.cityDTO = cityDTO;
		this.description = description;
	}

	public RentDTO(RentACar service) {
		this(service.getId(), service.getName(), service.getAddress(), new CityDTO(service.getCity()), service.getDescription());
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

	public CityDTO getCityDTO() {
		return cityDTO;
	}

	public void setCityDTO(CityDTO cityDTO) {
		this.cityDTO = cityDTO;
	}
}
