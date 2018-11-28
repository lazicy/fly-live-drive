package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Vozilo;

public class VoziloDTO {
	
	private Long id;
	private String model;
	private String brand;
	
	public VoziloDTO() {
		
	}

	public VoziloDTO(Long id, String model, String brand) {
		this.id = id;
		this.model = model;
		this.brand = brand;
	}

	public VoziloDTO(Vozilo vozilo) {
		this(vozilo.getId(), vozilo.getModel(), vozilo.getBrand());
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}
	
}
