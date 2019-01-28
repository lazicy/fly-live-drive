package com.bff.flylivedrive.dto.mappers;

import com.bff.flylivedrive.dto.InterceptionDTO;
import com.bff.flylivedrive.model.Destination;
import com.bff.flylivedrive.model.Flight;
import com.bff.flylivedrive.model.Interception;

public class InterceptionMapper {
	
	public InterceptionMapper() {
		
	}
	
	public Interception map(InterceptionDTO iDTO, Destination d, Flight f) {
		
		Interception i = new Interception();
		
		
		// set interception
		i.setDestination(d);
		i.setDuration(iDTO.getDuration());
		i.setTakeOff(iDTO.getTakeOff());
		i.setLanding(iDTO.getLanding());
		i.setFlight(f);
		
		return i;
				
	}

}
