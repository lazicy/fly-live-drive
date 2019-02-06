package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Usluga;

public class UslugaDTO {
	
	private Long id;
	private String name;
	private double price;
	private String charge;
	private double discount;
	
	public UslugaDTO() {
		
	}
	
	public UslugaDTO(Usluga s) {
		this(s.getId(), s.getName(), s.getPrice(), s.getCharge(), s.getDiscount());
	}
	
	public UslugaDTO(Long id, String name, double price, String charge, double discount) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.charge = charge;
		this.discount = discount;
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

	public double getDiscount() {
		return discount;
	}

	public void setDiscount(double discount) {
		this.discount = discount;
	}
}
