package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bff.flylivedrive.dto.CityDTO;
import com.bff.flylivedrive.dto.HotelDTO;
import com.bff.flylivedrive.dto.UslugaDTO;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Hotel;
import com.bff.flylivedrive.model.Usluga;
import com.bff.flylivedrive.service.CityService;
import com.bff.flylivedrive.service.HotelService;
import com.bff.flylivedrive.service.UslugaService;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	CityService cityService;
	
//	@Autowired
//	private RoomService roomService;
//	
	@Autowired
	UslugaService uslugaService;
	
	
	@RequestMapping(value = "/all", method = RequestMethod.GET)
	public ResponseEntity<List<HotelDTO>> getAllHotel() {
		
		List<Hotel> hotels = hotelService.findAll();
		List<HotelDTO> hotelsDTO = new ArrayList<>();
		
		for (Hotel h : hotels) {
			HotelDTO hDTO = new HotelDTO(h);
			hotelsDTO.add(hDTO);
		}
		
		return new ResponseEntity<>(hotelsDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<HotelDTO> getHotel(@PathVariable Long id) {
		
		Hotel hotel = hotelService.findOneById(id);
		
		if(hotel == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<>(new HotelDTO(hotel), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<HotelDTO> saveHotel(@RequestBody HotelDTO hotelDTO) {
		
		City c = cityService.findOneById(hotelDTO.getCityDTO().getId());
		
		Hotel hotel = new Hotel();
		
		hotel.setName(hotelDTO.getName());
		hotel.setAddress(hotelDTO.getAddress());
		hotel.setCity(c);
		hotel.setDescription(hotelDTO.getDescription());
		hotel.setHotelImageURL(hotelDTO.getHotelImageURL());
		hotel.setMap(hotelDTO.getMap());
		hotel.setStars(hotelDTO.getStars());
		
		hotel = hotelService.save(hotel);
		
		return new ResponseEntity<HotelDTO>(new HotelDTO(hotel),HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteHotel(@PathVariable Long id){
		
		Hotel hotel = hotelService.findOneById(id);
		
		if(hotel != null) {
			hotelService.remove(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@RequestMapping(method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDTO) {
		
		//checking if hotel exists
		Hotel hotel = hotelService.findOneById(hotelDTO.getId());
		
		if (hotel == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		City c;
		
		try {
			c = cityService.findOneById(hotelDTO.getCityDTO().getId());
		} catch (NullPointerException e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		hotel.setName(hotelDTO.getName());
		hotel.setAddress(hotelDTO.getAddress());
		hotel.setCity(c);
		hotel.setDescription(hotelDTO.getDescription());
		hotel.setHotelImageURL(hotelDTO.getHotelImageURL());
		hotel.setMap(hotelDTO.getMap());
		hotel.setStars(hotelDTO.getStars());
		
		hotel = hotelService.save(hotel);
		
		return new ResponseEntity<>(new HotelDTO(hotel), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/search", method = RequestMethod.GET)
	public ResponseEntity<List<HotelDTO>> getSearchedHotels(@PathVariable String name) {
		
		List<Hotel> hotels = hotelService.search(name);
		List<HotelDTO> hotelsDTO = new ArrayList<>();
		
		for (Hotel h : hotels) {
			HotelDTO hDTO = new HotelDTO(h);
			hotelsDTO.add(hDTO);
		}
		
		return new ResponseEntity<>(hotelsDTO, HttpStatus.OK);
	}
	
	//ALL hotel services
	@RequestMapping(value = "/{hotelId}/services", method = RequestMethod.GET)
	public ResponseEntity<List<UslugaDTO>> getHotelServices(@PathVariable Long hotelId) {
		
		Hotel hotel = hotelService.findOneById(hotelId);
		if(hotel == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Set<Usluga> usluga = hotel.getUsluge();
		List<UslugaDTO> uslugaDTO = new ArrayList<>();
		for(Usluga s : usluga) {
			uslugaDTO.add(new UslugaDTO(s));
		}
		
		return new ResponseEntity<>(uslugaDTO, HttpStatus.OK);
	}
	
	//ONE hotel service
	@RequestMapping(value = "/service/{uslId}", method = RequestMethod.GET)
	public ResponseEntity<UslugaDTO> getHotelService(@PathVariable("uslId") Long uslId) {
		
		Usluga u = uslugaService.findOneById(uslId);
		
		if(u == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		UslugaDTO uslugaDTO = new UslugaDTO(u);
		
		return new ResponseEntity<>(uslugaDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/service/{id}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<UslugaDTO> saveUsluga(@RequestBody UslugaDTO uslugaDTO, @PathVariable("id") Long id) {
		Hotel h = hotelService.findOneById(id);
		
		if (h == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Usluga usl = new Usluga();
		usl.setName(uslugaDTO.getName());
		usl.setPrice(uslugaDTO.getPrice());
		usl.setCharge(uslugaDTO.getCharge());
		usl.setHotel(h);
		
		Set<Usluga> usluge = h.getUsluge();
		usluge.add(usl);
		
		usl = uslugaService.save(usl);
		
		return new ResponseEntity<>(new UslugaDTO(usl), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{idHot}/service/{idSer}", method=RequestMethod.DELETE)
	public ResponseEntity<Void> deleteService(@PathVariable("idHot") Long idHot, @PathVariable("idSer") Long idSer){
		
		Hotel hotel = hotelService.findOneById(idHot);
		
		if(hotel == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Usluga u = uslugaService.findOneById(idSer);
		
		if(u == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		uslugaService.remove(idSer);
		
		Set<Usluga> usluge = hotel.getUsluge();
		Iterator<Usluga> itr = usluge.iterator();
		while (itr.hasNext())
		{
		    Usluga us = itr.next();
		    if (us.getId().equals(idSer)) {
		        itr.remove();
		        break;
		    }
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value="/service/{idSer}", method=RequestMethod.PUT, consumes="application/json")
	public ResponseEntity<UslugaDTO> updateHotelService(@RequestBody UslugaDTO uslugaDTO, @PathVariable("idSer") Long id) {
		
		Hotel h = hotelService.findOneById(id);
		
		if (h == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Set<Usluga> usluge = h.getUsluge();
		Iterator<Usluga> itr = usluge.iterator();
		while (itr.hasNext())
		{
		    Usluga us = itr.next();
		    if (us.getId().equals(id)) {
		        us.setName(uslugaDTO.getName());
		        us.setPrice(uslugaDTO.getPrice());
		        us.setCharge(uslugaDTO.getCharge());
		        break;
		    }
		}
		
		Usluga usl = uslugaService.findOneById(uslugaDTO.getId());
		usl.setName(uslugaDTO.getName());
		usl.setPrice(uslugaDTO.getPrice());
		usl.setCharge(uslugaDTO.getCharge());
		
		usl = uslugaService.save(usl);
		
		return new ResponseEntity<UslugaDTO>(new UslugaDTO(usl),HttpStatus.CREATED);
	}
}
