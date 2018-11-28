package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Filijala;

public class FilijalaDTO {
	
	private Long id;
	private String name;
	private String adress;
	private String description;
	
	public FilijalaDTO() {
		
	}

	public FilijalaDTO(Long id, String name, String adress, String description) {
		this.id = id;
		this.name = name;
		this.adress = adress;
		this.description = description;
	}
	
	public FilijalaDTO(Filijala filijala) {
		this(filijala.getId(), filijala.getName(), filijala.getAdress(), filijala.getDescription());
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
}
