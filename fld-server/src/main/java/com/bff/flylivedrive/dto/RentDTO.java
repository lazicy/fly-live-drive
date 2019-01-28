package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.RentACar;

public class RentDTO {
	
	Long id;
	String name;
	String adress;
	CityDTO cityDTO;
	String description;
	
	public RentDTO() {
		
	}
	
	public RentDTO(Long id, String name, String adress, CityDTO cityDTO, String description) {
		super();
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.cityDTO = cityDTO;
		this.description = description;
	}

	public RentDTO(RentACar service) {
		this(service.getId(), service.getName(), service.getAdress(), new CityDTO(service.getCity()), service.getDescription());
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

	public CityDTO getCityDTO() {
		return cityDTO;
	}

	public void setCityDTO(CityDTO cityDTO) {
		this.cityDTO = cityDTO;
	}
	
	
}
