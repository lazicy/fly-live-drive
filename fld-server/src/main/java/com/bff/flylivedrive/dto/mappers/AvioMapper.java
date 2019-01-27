package com.bff.flylivedrive.dto.mappers;

import com.bff.flylivedrive.dto.AvioDTO;
import com.bff.flylivedrive.model.Avio;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Destination;

public class AvioMapper {
	
	public Avio map(AvioDTO aDTO, City c) {
		
		Avio a = new Avio();
		
		a.setName(aDTO.getName());
		a.setAddress(aDTO.getAddress());
		a.setCity(c);
		a.setMap(aDTO.getMap());
		a.setDescription(aDTO.getDescription());
		
		Destination d = new Destination();
		d.setAvio(a);
		d.setCity(c);
		
		a.getDestinations().add(d);
		
		
		return a;
		
	}

}
