package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Filijala;
import com.bff.flylivedrive.model.RentACar;

public class FilijalaDTO {
	
	private Long id;
	private String name;
	private String address;
	private CityDTO cityDTO;
	private String description;
	
	public FilijalaDTO() {
		
	}

	public FilijalaDTO(Long id, String name, String adress, CityDTO city, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = adress;
		this.cityDTO = city;
		this.description = description;
	}
	
	public FilijalaDTO(Filijala f) {
		this(f.getId(),f.getName(),f.getAddress(),new CityDTO(f.getCity()),f.getDescription());
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
