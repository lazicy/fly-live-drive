package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Hotel;

public class HotelDTO {
	
	private Long id;
	private String name;
	private String address;
	private String description;
	
	public HotelDTO() {
		
	}
	
	public HotelDTO(Hotel h) {
		this(h.getId(), h.getName(), h.getAddress(), h.getDescription());
	}
	
	public HotelDTO(Long id, String name, String address, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
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

	public void setAddress(String address) {
		this.address = address;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
}
