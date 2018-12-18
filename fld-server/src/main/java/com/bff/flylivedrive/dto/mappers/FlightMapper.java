package com.bff.flylivedrive.dto.mappers;

import java.util.Set;

import com.bff.flylivedrive.dto.FlightDTO;
import com.bff.flylivedrive.model.Avio;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Flight;

public class FlightMapper {
	
	public FlightMapper() {
		
	}
	
	// mapping without interceptions
	public Flight map (FlightDTO flightDTO, Avio a, City departureCity, City landingCity) {
		
		Flight flight = new Flight();
		
		flight.setId(flightDTO.getId());
		flight.setDepartureDate(flightDTO.getDepartureDate());
		flight.setLandingDate(flightDTO.getLandingDate());
		flight.setPrice(flightDTO.getPrice());
		flight.setAvio(a);
		flight.setDepartureCity(departureCity);
		flight.setLandingCity(landingCity);
		
		return flight;
		
	}

}
