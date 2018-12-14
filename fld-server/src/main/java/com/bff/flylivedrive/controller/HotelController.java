package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bff.flylivedrive.dto.HotelDTO;
import com.bff.flylivedrive.model.Hotel;
import com.bff.flylivedrive.service.HotelService;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
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
		
		Hotel hotel = new Hotel();
		
		hotel.setName(hotelDTO.getName());
		hotel.setAddress(hotelDTO.getAddress());
		hotel.setCity(hotelDTO.getCity());
		hotel.setCountry(hotelDTO.getCountry());
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
	public ResponseEntity<HotelDTO> updateHotel(@RequestBody HotelDTO hotelDTO){
		
		//checking if hotel exists
		Hotel hotel = hotelService.findOneById(hotelDTO.getId());
		
		if (hotel == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		hotel.setName(hotelDTO.getName());
		hotel.setAddress(hotelDTO.getAddress());
		hotel.setCity(hotelDTO.getCity());
		hotel.setCountry(hotelDTO.getCountry());
		hotel.setDescription(hotelDTO.getDescription());
		hotel.setHotelImageURL(hotelDTO.getHotelImageURL());
		hotel.setMap(hotelDTO.getMap());
		hotel.setStars(hotelDTO.getStars());
		
		hotel = hotelService.save(hotel);
		
		return new ResponseEntity<>(new HotelDTO(hotel), HttpStatus.OK);
	}
}
