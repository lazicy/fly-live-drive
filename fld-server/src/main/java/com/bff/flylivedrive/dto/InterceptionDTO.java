package com.bff.flylivedrive.dto;

import java.util.Date;

import com.bff.flylivedrive.model.Interception;

public class InterceptionDTO {
	
	private long id;
	private Date takeOff;
	private Date landing;
	private int duration;
	private CityDTO city;
	private FlightDTO flight;
	
	
	public InterceptionDTO() {
		
	}
	
	public InterceptionDTO(Interception i) {
		this(i.getId(), i.getTakeOff(), i.getLanding(), i.getDuration(), new CityDTO(i.getCity()), new FlightDTO(i.getFlight()));
	}
	
	public InterceptionDTO(long id, Date takeOff, Date landing, int duration, CityDTO city, FlightDTO flight) {
		super();
		this.id = id;
		this.takeOff = takeOff;
		this.landing = landing;
		this.duration = duration;
		this.city = city;
		this.flight = flight;
	}
	
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Date getTakeOff() {
		return takeOff;
	}
	public void setTakeOff(Date takeOff) {
		this.takeOff = takeOff;
	}
	public Date getLanding() {
		return landing;
	}
	public void setLanding(Date landing) {
		this.landing = landing;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}
	public CityDTO getCity() {
		return city;
	}
	public void setCity(CityDTO city) {
		this.city = city;
	}
	public FlightDTO getFlight() {
		return flight;
	}
	public void setFlight(FlightDTO flight) {
		this.flight = flight;
	}
	
	
	

}
