package com.bff.flylivedrive.dto;

import java.util.Date;

public class SearchFlightDTO {
	
	private Date departureDate;
	private Date returnDate;
	private CityDTO fromCity;
	private CityDTO toCity;
	int numberOfPeople;
	String tripType;
	
	public SearchFlightDTO() {
		
	}
	
	
	public Date getDepartureDate() {
		return departureDate;
	}
	public void setDepartureDate(Date departureDate) {
		this.departureDate = departureDate;
	}
	public Date getReturnDate() {
		return returnDate;
	}
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	public CityDTO getFromCity() {
		return fromCity;
	}
	public void setFromCity(CityDTO fromCity) {
		this.fromCity = fromCity;
	}
	public CityDTO getToCity() {
		return toCity;
	}
	public void setToCity(CityDTO toCity) {
		this.toCity = toCity;
	}
	public int getNumberOfPeople() {
		return numberOfPeople;
	}
	public void setNumberOfPeople(int numberOfPeople) {
		this.numberOfPeople = numberOfPeople;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	
	
	

}
