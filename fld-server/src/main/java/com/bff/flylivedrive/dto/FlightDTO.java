package com.bff.flylivedrive.dto;

import java.util.Date;

import com.bff.flylivedrive.model.Avio;
import com.bff.flylivedrive.model.Flight;

public class FlightDTO {
	
	
	private Long id;private Date departureDate;
	private Date landingDate;
	private double price;
	private AvioDTO avioDTO;
	
	
	public FlightDTO() {
		
	}
	
	public FlightDTO(Flight f) {
		this(f.getId(), f.getDepartureDate(), f.getLandingDate(), f.getPrice(), new AvioDTO(f.getAvio()));
	}
	
	public FlightDTO(Long id, Date departureDate, Date landingDate, double price, AvioDTO avioDTO) {
		super();
		this.id = id;
		this.departureDate = departureDate;
		this.landingDate = landingDate;
		this.price = price;
		this.avioDTO = avioDTO;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getLandingDate() {
		return landingDate;
	}
	public void setLandingDate(Date landingDate) {
		this.landingDate = landingDate;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public AvioDTO getAvioDTO() {
		return avioDTO;
	}
	public void setAvioDTO(AvioDTO avioDTO) {
		this.avioDTO = avioDTO;
	}


	
}
