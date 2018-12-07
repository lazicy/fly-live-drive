package com.bff.flylivedrive.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import com.bff.flylivedrive.model.Flight;
import com.bff.flylivedrive.model.Interception;

public class FlightDTO {
	
	
	private Long id;
	private Date departureDate;
	private Date landingDate;
	private int totalDuration;
	private CityDTO departureCity;
	private CityDTO landingCity;
	private double price;
	private AvioDTO avioDTO;
	private List<InterceptionDTO> interceptionsDTO;
	
	public FlightDTO() {
		
	}
	
	public FlightDTO(Flight f) {
		this(f.getId(), f.getDepartureDate(), f.getLandingDate(), f.getTotalDuration(),
				new CityDTO(f.getDepartureCity()), new CityDTO(f.getLandingCity()), f.getPrice(), new AvioDTO(f.getAvio()));
		
		// mapping to interceptionsDTO list
		interceptionsDTO = new ArrayList<>();
		
		Iterator it = f.getInterceptions().iterator();
		
		while (it.hasNext()) {
			Interception i = (Interception)it.next();
			interceptionsDTO.add(new InterceptionDTO(i));
		}
		
		
		
	}
	
	
	
	public FlightDTO(Long id, Date departureDate, Date landingDate, int totalDuration,
			CityDTO departureCity, CityDTO landingCity, double price, AvioDTO avioDTO) {
		super();
		this.id = id;
		this.departureDate = departureDate;
		this.landingDate = landingDate;
		this.totalDuration = totalDuration;
		this.departureCity = departureCity;
		this.landingCity = landingCity;
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

	public int getTotalDuration() {
		return totalDuration;
	}

	public void setTotalDuration(int totalDuration) {
		this.totalDuration = totalDuration;
	}


	public CityDTO getDepartureCity() {
		return departureCity;
	}

	public void setDepartureCity(CityDTO departureCity) {
		this.departureCity = departureCity;
	}

	public CityDTO getLandingCity() {
		return landingCity;
	}

	public void setLandingCity(CityDTO landingCity) {
		this.landingCity = landingCity;
	}

	public List<InterceptionDTO> getInterceptionsDTO() {
		return interceptionsDTO;
	}

	public void setInterceptionsDTO(List<InterceptionDTO> interceptionsDTO) {
		this.interceptionsDTO = interceptionsDTO;
	}

	
	


	
}
