package com.bff.flylivedrive.dto.mappers;

import java.util.Iterator;

import org.springframework.beans.factory.annotation.Autowired;

import com.bff.flylivedrive.dto.AvioDTO;
import com.bff.flylivedrive.model.Avio;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Destination;
import com.bff.flylivedrive.service.AvioService;
import com.bff.flylivedrive.service.DestinationService;

public class AvioMapper {
	
	@Autowired 
	AvioService avioService;
	
	@Autowired
	DestinationService destService;
	
	public Avio mapNew(AvioDTO aDTO, City c) {
		
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
	
	public Avio mapUpdate(AvioDTO aDTO, Avio a, City c) {
		
		
		
		a.setName(aDTO.getName());
		a.setAddress(aDTO.getAddress());
		a.setMap(aDTO.getMap());
		a.setDescription(aDTO.getDescription());
		a.setCity(c);
		
		
		return a;
	}

}
