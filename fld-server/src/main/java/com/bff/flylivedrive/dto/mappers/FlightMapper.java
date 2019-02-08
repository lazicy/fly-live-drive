package com.bff.flylivedrive.dto.mappers;

import com.bff.flylivedrive.dto.FlightDTO;
import com.bff.flylivedrive.model.Avio;
import com.bff.flylivedrive.model.Destination;
import com.bff.flylivedrive.model.Flight;

public class FlightMapper {
	
	public FlightMapper() {
		
	}
	
	// mapping without interceptions
	public Flight map (FlightDTO flightDTO, Avio a, Destination departureDest, Destination landingDest) {
		
		Flight flight = new Flight();
		
		flight.setId(flightDTO.getId());
		flight.setDepartureDate(flightDTO.getDepartureDate());
		flight.setLandingDate(flightDTO.getLandingDate());
		flight.setPrice(flightDTO.getPrice());
		flight.setAvio(a);
		flight.setDepartureDestination(departureDest);
		flight.setLandingDestination(landingDest);
		flight.setTotalDuration(flightDTO.getTotalDuration());
		
		
		return flight;
		
	}

}
