package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Usluga;

public class UslugaDTO {
	
	private Long id;
	private String name;
	private double price;
	private String charge;
	
	public UslugaDTO() {
		
	}
	
	public UslugaDTO(Usluga s) {
		this(s.getId(), s.getName(), s.getPrice(), s.getCharge());
	}
	
	public UslugaDTO(Long id, String name, double price, String charge) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.charge = charge;
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCharge() {
		return charge;
	}

	public void setCharge(String charge) {
		this.charge = charge;
	}
}
