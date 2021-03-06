package com.bff.flylivedrive.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bff.flylivedrive.dto.CityDTO;
import com.bff.flylivedrive.dto.CountryDTO;
import com.bff.flylivedrive.dto.FilijalaDTO;
import com.bff.flylivedrive.dto.RentDTO;
import com.bff.flylivedrive.dto.VehicleSearchParams;
import com.bff.flylivedrive.dto.VoziloDTO;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Country;
import com.bff.flylivedrive.model.Filijala;
import com.bff.flylivedrive.model.RentACar;
import com.bff.flylivedrive.model.VehicleReservation;
import com.bff.flylivedrive.model.Vozilo;
import com.bff.flylivedrive.service.FilijalaService;
import com.bff.flylivedrive.service.CityService;
import com.bff.flylivedrive.service.CountryService;
import com.bff.flylivedrive.service.FastResVehicleService;
import com.bff.flylivedrive.service.RentService;
import com.bff.flylivedrive.service.VehicleReservationService;
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
	
	@Autowired
	CityService cityService;
	
	@Autowired
	CountryService countryService;
	
	@Autowired
	VehicleReservationService vResService;
	
	@Autowired 
	FastResVehicleService frService; 
	
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
	public ResponseEntity<List<RentDTO>> getServicesFilter(@PathVariable("name") String param){
		param = param.replace("-", " ");
		RentACar rent = rentService.findByName(param);
		List<RentACar> rents = rentService.findAllByCity(param);
		List<RentDTO> rentsDTO = new ArrayList<RentDTO>(); 
		if(rent == null) {
			
			if(rents != null) {
				for(RentACar r: rents) {
					rentsDTO.add(new RentDTO(r));
				}
			}else{
				return new ResponseEntity<>(rentsDTO, HttpStatus.NOT_FOUND);
			}
			
		}else if(rents.isEmpty()){
			
			if(rent != null) {
				rentsDTO.add(new RentDTO(rent));
			}else{
				return new ResponseEntity<>(rentsDTO, HttpStatus.NOT_FOUND);
			}
			
		}
		return new ResponseEntity<>(rentsDTO, HttpStatus.OK);
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
		City c;
		
		try {
			c = cityService.findOneById(rentDTO.getCityDTO().getId());
		} catch (NullPointerException e) {
			System.out.println("[RentController: editRent()] City NULL");
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
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
		rentAcar.setAddressOnMap(rentDTO.getAddressOnMap());
		rentAcar.setCity(c);
		rentAcar.setDescription(rentDTO.getDescription());
		
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
	
	@RequestMapping(value="/getBranchOffice/{id}", method = RequestMethod.GET)
	public ResponseEntity<FilijalaDTO> getBranchOffice(@PathVariable("id")Long id){
		Filijala f = fService.findOneById(id);
		return new ResponseEntity<>(new FilijalaDTO(f),HttpStatus.OK);
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
	
	
	@RequestMapping(value = "/getAllVehicles/{idF}",method = RequestMethod.GET)
	public ResponseEntity<List<VoziloDTO>> getAllVehicles(@PathVariable("idF") Long idF){
		Filijala f = fService.findOneById(idF);
		if(f == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<VoziloDTO> temp = new ArrayList<VoziloDTO>();
		for(Vozilo v: f.getVozila()) {
			temp.add(new VoziloDTO(v));
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
		Vozilo v = vService.findOneById(id);
		Date d = new Date();
		
		//ako je rezervisano onda ne sme da brise
		if((boolean) v.getVehicleReservation().getDropOffDate().before(d)) {
			return new ResponseEntity<>(HttpStatus.FORBIDDEN);
		}
		
		vService.deleteById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(value = "/editVehicle/{idF}", method = RequestMethod.PUT)
	public ResponseEntity<VoziloDTO> editVehicle(@RequestBody VoziloDTO voziloDTO, @PathVariable("idF") Long idF){
		Vozilo vozilo = vService.findOneById(voziloDTO.getId());
		Filijala filijala = fService.findOneById(idF);
		vozilo = new Vozilo(voziloDTO);
		vozilo.setFilijala(filijala);
		
		Date d = new Date();
		if((boolean) vozilo.getVehicleReservation().getDropOffDate().before(d)) {
			return new ResponseEntity<>(null,HttpStatus.FORBIDDEN);
		}
		
		vozilo = vService.save(vozilo);
		return new ResponseEntity<>(new VoziloDTO(vozilo), HttpStatus.OK);
	}
	
	@RequestMapping(value="/getVehicle/{idV}", method = RequestMethod.GET)
	public ResponseEntity<VoziloDTO> getVehicle(@PathVariable("idV")Long id){
		Vozilo v = vService.findOneById(id);
		return new ResponseEntity<>(new VoziloDTO(v),HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRENTVehicles/{id}",method = RequestMethod.GET)
	public ResponseEntity<List<VoziloDTO>> getRENTVehicles(@PathVariable("id") Long id){
		
		RentACar rent = rentService.findOneById(id);
		if(rent == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		List<VoziloDTO> temp = new ArrayList<VoziloDTO>();
		
		for(Filijala f : rent.getFilijale()) {
			for(Vozilo v : f.getVozila()) {
				temp.add(new VoziloDTO(v));
			}
		}
		
		return new ResponseEntity<>(temp, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getRentCountries/{id}", method = RequestMethod.GET)
	public ResponseEntity<List<CountryDTO>> getRentCountries(@PathVariable("id") Long id){
		List<Country> countries = countryService.getRentCountries(id);
		if(countries == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		List<CountryDTO> countriesDTO = new ArrayList<CountryDTO>();
		for(Country c: countries) {
			countriesDTO.add(new CountryDTO(c));
		}
		
		return new ResponseEntity<>(countriesDTO, HttpStatus.OK);
	}
	
	@RequestMapping(value = "/getCityByCountryId/{idR}/{idC}", method = RequestMethod.GET)
	public ResponseEntity<List<CityDTO>> getCityByCountryId(@PathVariable("idC") Long idC, @PathVariable("idR") Long idR){
		//lista gradova za zemlju 
		List<City> cities = cityService.findCityByCountryId(idC);
		//za filijale servisa nadji u kojim gradovima za konkretnu zemlju posloju
		RentACar rent = rentService.findOneById(idR);
		Set<Filijala> filijale = rent.getFilijale();
		List<CityDTO> citiesDTO = new ArrayList<CityDTO>();
		for(Filijala f: filijale) {
			for(City c: cities) {
				if(c.getId().equals(f.getCity().getId())) {
					citiesDTO.add(new CityDTO(c));
					break;
				}
			}
		}
		return new ResponseEntity<>(citiesDTO,HttpStatus.OK);
	}
	
	@RequestMapping(value = "/searchVehicles", method = RequestMethod.POST)
	public ResponseEntity<List<VoziloDTO>> getVehiclesSearch(@RequestBody VehicleSearchParams params){
		
		City c = cityService.findOneById(Long.parseLong(params.getCity()));
		List<VoziloDTO> res = new ArrayList<VoziloDTO>();
		List<VehicleReservation> vRes = vResService.findAll();
		
		
		if(vRes.isEmpty()) {
			List<Vozilo> vAll = vService.findAllByCityId(c.getId());
			for(Vozilo v: vAll) {
				res.add(new VoziloDTO(v));
			}
			
			List<Vozilo> fastVozila = vService.findFast(params.getPickUp(), params.getDropOff());
			List<VoziloDTO> toRemove = new ArrayList<VoziloDTO>(); 
			//treba videti da li su u datom periodu na brzoj rez
			for(Vozilo v: fastVozila) {
				for(VoziloDTO vres : res) {
					if(vres.getId().equals(v.getId())) {
						toRemove.add(vres);
						break;
					}
				}
			}
			if(!toRemove.isEmpty()) {
				res.removeAll(toRemove);
			}
			
			return new ResponseEntity<>(res, HttpStatus.OK);
		}
		
		//vozila koja nisu rezervisana
		List<Vozilo> notResVehicles = new ArrayList<Vozilo>();
		//vozila koja su rezervisana ali ne u datom periodu pretrage
		List<Vozilo> resVehicles = new ArrayList<Vozilo>();
		
		if(params.getSeats() != 0) {
			resVehicles = vService.getResVehicles(params.getPickUp(), params.getDropOff(), c.getId(), params.getSeats());
			notResVehicles = vService.getNotResVehicles(c.getId(),params.getSeats());
		}else{
			resVehicles = vService.getResVehicles(params.getPickUp(), params.getDropOff(), c.getId());
			notResVehicles = vService.getNotResVehicles(c.getId());
		}
		
		
		for(Vozilo v: notResVehicles) {
			res.add(new VoziloDTO(v));
		}
		for(Vozilo v: resVehicles) {
			res.add(new VoziloDTO(v));
		}
		List<Vozilo> fastVozila = vService.findFast(params.getPickUp(), params.getDropOff());
		List<VoziloDTO> toRemove = new ArrayList<VoziloDTO>(); 
		
		//treba videti da li su u datom periodu na brzoj rez
		for(Vozilo v: fastVozila) {
			for(VoziloDTO vres : res) {
				if(vres.getId().equals(v.getId())) {
					toRemove.add(vres);
					break;
				}
			}
		}
		
		if(!toRemove.isEmpty()) {
			res.removeAll(toRemove);
		}
		
		return new ResponseEntity<>(res, HttpStatus.OK);
	}
}
