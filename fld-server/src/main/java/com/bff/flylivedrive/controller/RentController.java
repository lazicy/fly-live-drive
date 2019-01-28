package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bff.flylivedrive.dto.RentDTO;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Filijala;
import com.bff.flylivedrive.model.RentACar;
import com.bff.flylivedrive.service.CityService;
import com.bff.flylivedrive.service.RentService;

@RestController
@RequestMapping(value = "/rent") //kako gadjamo ovaj kontroler sa front-a
public class RentController {
	
	@Autowired
	RentService rentService; //injektujem potreban servis
	
	@Autowired
	CityService cityService;
	
	@RequestMapping(value = "/all",method = RequestMethod.GET)
	public ResponseEntity<List<RentDTO>> getAllServices(){
			List<RentACar> services = rentService.findAll();
			ArrayList<RentDTO> temp = new ArrayList<RentDTO>();
			for(RentACar s: services) {
				RentDTO r = new RentDTO(s);
				temp.add(r);
			}
			return new ResponseEntity<>(temp, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	@PreAuthorize("hasRole('RENT_ADMIN')")
	public ResponseEntity<RentDTO> saveRent(@RequestBody RentDTO rent){
		City c = cityService.findOneById(rent.getCityDTO().getId());
		
		RentACar rentAcar = new RentACar();
		
		rentAcar.setName(rent.getName());
		rentAcar.setAdress(rent.getAdress());
		rentAcar.setCity(c);
		rentAcar.setDescription(rent.getDescription());
		
		//kreiraj novi objekat i sacuvaj ga u bazu
		rentAcar = rentService.save(rentAcar);
		
		//kreiraj dto objekat koji odgovara formatu za front i vrati status da je kreirano
		return new ResponseEntity<>(new RentDTO(rentAcar), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	@PreAuthorize("hasRole('RENT_ADMIN')")
	public  ResponseEntity<Object> deleteRent(@PathVariable("id") Long id){
		rentService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.PUT)
	@PreAuthorize("hasRole('RENT_ADMIN')")
	public ResponseEntity<RentDTO> editRent(@PathVariable("id") Long id){
		return null;
	}
	
	@RequestMapping(value = "/addBranch", method = RequestMethod.POST)
	@PreAuthorize("hasRole('RENT_ADMIN')")
	public ResponseEntity<?> addBranch(@RequestBody Filijala filijala){
		return null;
	}
	
	
}
