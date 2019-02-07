package com.bff.flylivedrive.dto;

import java.util.List;

public class SearchFlightResultDTO {
	
	List<FlightDTO> departureFlights;
	List<FlightDTO> returnFlights;
	String tripType;
	
	public SearchFlightResultDTO() {
		
	}
	
	
	public SearchFlightResultDTO(List<FlightDTO> departureFlights, List<FlightDTO> returnFlights, String tripType) {
		super();
		this.departureFlights = departureFlights;
		this.returnFlights = returnFlights;
		this.tripType = tripType;
	}
	public List<FlightDTO> getDepartureFlights() {
		return departureFlights;
	}
	public void setDepartureFlights(List<FlightDTO> departureFlights) {
		this.departureFlights = departureFlights;
	}
	public List<FlightDTO> getReturnFlights() {
		return returnFlights;
	}
	public void setReturnFlights(List<FlightDTO> returnFlights) {
		this.returnFlights = returnFlights;
	}
	public String getTripType() {
		return tripType;
	}
	public void setTripType(String tripType) {
		this.tripType = tripType;
	}
	
	

}
