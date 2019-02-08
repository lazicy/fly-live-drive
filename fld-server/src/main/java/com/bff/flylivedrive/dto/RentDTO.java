package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.RentACar;

public class RentDTO {
	
	private Long id;
	private String name;
	private String address;
	private CityDTO cityDTO;
	private String description;
	private String addressOnMap;
	
	public RentDTO() {
		
	}
	
	public RentDTO(Long id, String name, String adress, CityDTO cityDTO, String description, String addressOnMap) {
		super();
		this.id = id;
		this.name = name;
		this.address = adress;
		this.cityDTO = cityDTO;
		this.description = description;
		this.addressOnMap = addressOnMap;
	}

	public RentDTO(RentACar service) {
		this(service.getId(), service.getName(), service.getAddress(), new CityDTO(service.getCity()), service.getDescription(),service.getAddressOnMap());
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

	public String getAddressOnMap() {
		return addressOnMap;
	}

	public void setAddressOnMap(String addressOnMap) {
		this.addressOnMap = addressOnMap;
	}
	
	
}
