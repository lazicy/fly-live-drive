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

import com.bff.flylivedrive.dto.FastResVehicleDTO;
import com.bff.flylivedrive.dto.VehicleFastDTO;
import com.bff.flylivedrive.dto.VoziloDTO;
import com.bff.flylivedrive.model.FastResVehicle;
import com.bff.flylivedrive.model.Vozilo;
import com.bff.flylivedrive.service.FastResVehicleService;
import com.bff.flylivedrive.service.VoziloService;

@RestController
@RequestMapping(value = "/fastResVehicle")
public class FastResVehicleController {
	
	@Autowired
	FastResVehicleService resService;
	
	@Autowired
	VoziloService voziloService;
	
	
	@RequestMapping(value = "/newFastRes", method = RequestMethod.POST)
	public ResponseEntity<FastResVehicleDTO> newFastRes(@RequestBody FastResVehicleDTO frDTO){
		FastResVehicle fr = new FastResVehicle();
		fr.setEndDate(frDTO.getEndDate());
		fr.setStartDate(frDTO.getStartDate());
		fr.setDiscount(frDTO.getDiscount());
		fr = resService.save(fr);
		frDTO.setId(fr.getId());
		return new ResponseEntity<>(frDTO, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getRes/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<FastResVehicleDTO>> getRes(@PathVariable("id") String id){
		List<FastResVehicle> all = resService.getAllforRent(Long.parseLong(id));
		
		List<FastResVehicleDTO> allDTO = new ArrayList<FastResVehicleDTO>();
		for(FastResVehicle frsv : all) {
			FastResVehicleDTO temp = new FastResVehicleDTO();
			temp = temp.getDTO(frsv);
			allDTO.add(temp);
		}
		
		return new ResponseEntity<>(allDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/addVehicleToRes", method = RequestMethod.POST)
	public ResponseEntity<Object> addVehicleToRes(@RequestBody VehicleFastDTO vFastDTO){
		FastResVehicle fr = resService.findOneById(vFastDTO.getIdRes());
		Vozilo vozilo = voziloService.findOneById(vFastDTO.getIdVehicle());
		//proveri da li je u rezervaciji
		for(Vozilo v : fr.getVozila()) {
			if(v.getId().equals(vozilo.getId())) {
				return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
			}
		}
		
		fr.getVozila().add(vozilo);
		vozilo.setFastRes(fr);
		vozilo = voziloService.save(vozilo);
		fr = resService.save(fr);
		
		return new ResponseEntity<>(null, HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/getFastVehicles/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<VoziloDTO>> getFastVehicles(@PathVariable("id") Long id){
		List<Vozilo> vozila = voziloService.findAllFastRes(id);
		
		if(vozila == null) {
			return new ResponseEntity<>(null,HttpStatus.NOT_FOUND);
		}
		
		List<VoziloDTO> vozilaDTO = new ArrayList<VoziloDTO>();
		for(Vozilo v: vozila) {
			VoziloDTO vDTO = new VoziloDTO(v);
			FastResVehicleDTO temp = new FastResVehicleDTO();
			temp = temp.getDTO(v.getFastRes());
			vDTO.setFrDTO(temp);
			vozilaDTO.add(vDTO);
		}
		
		return new ResponseEntity<>(vozilaDTO, HttpStatus.OK);
	}

}
