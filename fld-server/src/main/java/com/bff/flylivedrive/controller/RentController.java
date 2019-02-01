package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.bff.flylivedrive.dto.FilijalaDTO;
import com.bff.flylivedrive.dto.RentDTO;
import com.bff.flylivedrive.dto.VoziloDTO;
import com.bff.flylivedrive.model.Filijala;
import com.bff.flylivedrive.model.RentACar;
import com.bff.flylivedrive.model.Vozilo;
import com.bff.flylivedrive.service.FilijalaService;
import com.bff.flylivedrive.service.RentService;
import com.bff.flylivedrive.service.VoziloService;

@RestController
@RequestMapping(value = "/rent") //kako gadjamo ovaj kontroler sa front-a
public class RentController {
	
	@Autowired
	RentService rentService; //injektujem potreban servis
	
	@Autowired
	FilijalaService fService;
	
	@Autowired
	VoziloService vService;
	
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
	
	@RequestMapping(value = "/getServicesFilter/{name}", method = RequestMethod.GET)
	public ResponseEntity<List<RentDTO>> getServicesFilter(@PathVariable("name") String name){
		List<RentACar> services = rentService.findAll();
		RentDTO rentDTO = new RentDTO();
		name = name.replace("-", " ");
		for(RentACar r: services) {
			if(r.getName().contains(name)) {
				rentDTO = new RentDTO(r);
				break;
			}
		}
		List<RentDTO> rents = new ArrayList<RentDTO>();
		rents.add(rentDTO);
		return new ResponseEntity<>(rents, HttpStatus.OK);
	}
	
	@RequestMapping(value="/getRent/{id}", method = RequestMethod.GET)
	public ResponseEntity<RentDTO> getRent(@PathVariable("id") Long id){
		RentACar rent = rentService.findOneById(id);
		
		if(rent == null) {
			return  new ResponseEntity<>(new RentDTO(rent), HttpStatus.NOT_FOUND);
		}
		
		return  new ResponseEntity<>(new RentDTO(rent), HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<RentDTO> saveRent(@RequestBody RentDTO rent){
		RentACar rentAcar = new RentACar(rent);
		//kreiraj novi objekat i sacuvaj ga u bazu
		rentAcar = rentService.save(rentAcar);
		
		//kreiraj dto objekat koji odgovara formatu za front i vrati status da je kreirano
		return new ResponseEntity<>(new RentDTO(rentAcar), HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/edit", method = RequestMethod.PUT)
	//@PreAuthorize("hasRole('RENT_ADMIN')")
	public ResponseEntity<RentDTO> editRent(@RequestBody RentDTO rentDTO){
		RentACar rentAcar = rentService.findOneById(rentDTO.getId());
	
		//promeni u svim filijalama
		//uzmi iz baze filijalu, promeni i sacuvaj
		for(Filijala f : rentAcar.getFilijale()) {
			f = fService.findOneById(f.getId());
			f.setName(rentDTO.getName());
			f.setDescription(rentDTO.getDescription());
			f = fService.save(f);
		}
		
		rentAcar.setName(rentDTO.getName());
		rentAcar.setAddress(rentDTO.getAddress());
		rentAcar.setCity(rentDTO.getCity());
		rentAcar.setCountry(rentDTO.getCountry());
		rentAcar.setDescription(rentDTO.getDescription());
		rentAcar.setRentImageUrl(rentDTO.getRentImageUrl());
		
		rentAcar = rentService.save(rentAcar);
		
		return new ResponseEntity<>(new RentDTO(rentAcar),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
	//@PreAuthorize("hasRole('RENT_ADMIN')")
	public  ResponseEntity<Object> deleteRent(@PathVariable("id") Long id){
		rentService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getAllBranches/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<FilijalaDTO>> getAllBranches(@PathVariable("id") Long id){
		RentACar rent = rentService.findOneById(id);
		 
		if(rent == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Set<Filijala> all = rent.getFilijale();
		
		List<FilijalaDTO> filijale = new ArrayList<FilijalaDTO>();
		for(Filijala f: all) {
			filijale.add(new FilijalaDTO(f));
		}
		
		return new ResponseEntity<>(filijale, HttpStatus.OK);
	}
	
	
	
	@RequestMapping(value = "/addBranch/{id}", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('RENT_ADMIN')")
	public ResponseEntity<FilijalaDTO> addBranch(@RequestBody FilijalaDTO filijalaDTO, @PathVariable("id") Long id){
		Filijala f = new Filijala(filijalaDTO);
		
		RentACar rent = rentService.findOneById(id); //nadji za koji servis je vezana filijala
		f.setServis(rent);
		f.setName(rent.getName());
		f.setDescription(rent.getDescription());
		
		f = fService.save(f);
		return new ResponseEntity<>(new FilijalaDTO(f),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/deleteBranch/{idF}", method = RequestMethod.DELETE)
	//@PreAuthorize("hasRole('RENT_ADMIN')")
	public  ResponseEntity<Object> deleteBranch(@PathVariable("idF") Long idF){
		fService.deleteById(idF);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/editBranchOffice/{idR}", method = RequestMethod.PUT)
	//@PreAuthorize("hasRole('RENT_ADMIN')")
	public ResponseEntity<FilijalaDTO> editBranchOffice(@PathVariable("idR") Long idR,@RequestBody FilijalaDTO filijalaDTO){
		Filijala filijala = fService.findOneById(filijalaDTO.getId());
		RentACar rent = rentService.findOneById(idR);
		filijala = new Filijala(filijalaDTO);
		filijala.setName(rent.getName());
		filijala.setDescription(rent.getDescription());
		filijala.setServis(rent);
		
		filijala = fService.save(filijala);
		
		return new ResponseEntity<>(new FilijalaDTO(filijala),HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getAllVehicles/{idR}/{idF}",method = RequestMethod.GET)
	public ResponseEntity<List<VoziloDTO>> getAllVehicles(@PathVariable("idR") Long idR, @PathVariable("idF") Long idF){
		RentACar rent = rentService.findOneById(idR);
		 
		if(rent == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Set<Filijala> all = rent.getFilijale();
		List<VoziloDTO> temp = new ArrayList<VoziloDTO>();
		
		for(Filijala f: all) {
			if(f.getId() == idF) {
				for(Vozilo v: f.getVozila()) {
					temp.add(new VoziloDTO(v));
				}
				break;
			}
		}
		return new ResponseEntity<>(temp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addVehicle/{id}", method = RequestMethod.POST)
	//@PreAuthorize("hasRole('RENT_ADMIN')")
	public ResponseEntity<VoziloDTO> addVehicle(@RequestBody VoziloDTO voziloDTO, @PathVariable("id") Long id){
		Filijala filijala = fService.findOneById(id);
		Vozilo vozilo = new Vozilo(voziloDTO);
		vozilo.setFilijala(filijala);
		vozilo = vService.save(vozilo);
		
		filijala.getVozila().add(vozilo);
		filijala = fService.save(filijala);
		return new ResponseEntity<>(new VoziloDTO(vozilo),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/deleteVehicle/{id}", method = RequestMethod.DELETE)
	//@PreAuthorize("hasRole('RENT_ADMIN')")
	public  ResponseEntity<Object> deleteVehicle(@PathVariable("id") Long id){
		vService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/editVehicle/{idF}", method = RequestMethod.PUT)
	public ResponseEntity<VoziloDTO> editVehicle(@RequestBody VoziloDTO voziloDTO, @PathVariable("idF") Long idF){
		Vozilo vozilo = vService.findOneById(voziloDTO.getId());
		Filijala filijala = fService.findOneById(idF);
		vozilo = new Vozilo(voziloDTO);
		vozilo.setFilijala(filijala);
		vozilo = vService.save(vozilo);
		return new ResponseEntity<>(new VoziloDTO(vozilo), HttpStatus.OK);
	}
	
}
