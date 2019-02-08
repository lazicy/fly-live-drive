package com.bff.flylivedrive.controller;

import java.util.ArrayList;
import java.util.Iterator;
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

import com.bff.flylivedrive.dto.HotelDTO;
import com.bff.flylivedrive.dto.RoomDTO;
import com.bff.flylivedrive.dto.SearchHotelDTO;
import com.bff.flylivedrive.dto.UslugaDTO;
import com.bff.flylivedrive.model.City;
import com.bff.flylivedrive.model.Hotel;
import com.bff.flylivedrive.model.HotelReservation;
import com.bff.flylivedrive.model.Room;
import com.bff.flylivedrive.model.Usluga;
import com.bff.flylivedrive.service.CityService;
import com.bff.flylivedrive.service.HotelReservationService;
import com.bff.flylivedrive.service.HotelService;
import com.bff.flylivedrive.service.RoomService;
import com.bff.flylivedrive.service.UslugaService;

@RestController
@RequestMapping(value = "/hotel")
public class HotelController {
	
	@Autowired
	HotelService hotelService;
	
	@Autowired
	CityService cityService;
	
	@Autowired
	RoomService roomService;
	
	@Autowired
	UslugaService uslugaService;
	
	@Autowired
	HotelReservationService hotelRezService;
	
	
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
	//@PreAuthorize("hasRole('SYSTEM_ADMIN')")
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
	//@PreAuthorize("hasRole('SYSTEM_ADMIN')")
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
	//@PreAuthorize("hasRole('HOTEL_ADMIN')")
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
	
	@RequestMapping(value = "/search", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<List<HotelDTO>> getSearchedHotels(@RequestBody SearchHotelDTO shDTO) {
		
		List<City> city = cityService.findByNameContainingIgnoreCase(shDTO.getSearch());
		List<Hotel> hotels = hotelService.findByNameContainingIgnoreCase(shDTO.getSearch());
		if(city.size() == 0 && hotels.size() > 0) {
			List<Hotel> slobodni = new ArrayList<Hotel>();
			for(Hotel h : hotels) {
				List<Room> rooms = roomService.findByHotel(h.getId());
				boolean imaSlob = false;
				
				for(Room r : rooms) {
					boolean slobodna = false;
					
					if(r.getHotel_res().isEmpty()) {
						imaSlob = true;
						break;
					} else {
						for(HotelReservation hr : r.getHotel_res()) {
							if(((hr.getArrival_date()).after(shDTO.getCheckin()) && (hr.getArrival_date()).before(shDTO.getCheckout())) || ((shDTO.getCheckin()).after(hr.getArrival_date()) && (shDTO.getCheckin()).before(hr.getDeparture_date())) || ((shDTO.getCheckout()).after(hr.getArrival_date()) && (shDTO.getCheckout()).before(hr.getDeparture_date()))) {
								slobodna = false;
							} else {
								slobodna = true;
								break;
							}
						}
						if(slobodna) { {
							if(shDTO.getNumberOfPeople() >= r.getBeds() && shDTO.getNumberOfPeople() <=r.getPeople_capacity()) {
								imaSlob = true;
								break;
							}
						}
						}
					}
					
				}
				if(imaSlob) {
					slobodni.add(h);
				}
			}
			List<HotelDTO> hoteli = new ArrayList<HotelDTO>();
			if(slobodni.size() > 0) {
				for(Hotel h : slobodni) {
					hoteli.add(new HotelDTO(h));
				}
			}
			return new ResponseEntity<>(hoteli, HttpStatus.OK);
			
		} else if (city.size() > 0 && hotels.size() == 0) {
			List<Hotel> hotelKraj = new ArrayList<Hotel>();
			for(City c : city) {
				List<Hotel> ho = hotelService.findByCity(c.getId());
				for(Hotel h : ho) {
					List<Room> rooms = roomService.findByHotel(h.getId());
					boolean imaSlob = false;
					
					for(Room r : rooms) {
						boolean slobodna = false;
						
						if(r.getHotel_res().isEmpty()) {
							imaSlob = true;
							break;
						} else {
							for(HotelReservation hr : r.getHotel_res()) {
								if(((hr.getArrival_date()).after(shDTO.getCheckin()) && (hr.getArrival_date()).before(shDTO.getCheckout())) || ((shDTO.getCheckin()).after(hr.getArrival_date()) && (shDTO.getCheckin()).before(hr.getDeparture_date())) || ((shDTO.getCheckout()).after(hr.getArrival_date()) && (shDTO.getCheckout()).before(hr.getDeparture_date()))) {
									slobodna = false;
								} else {
									slobodna = true;
									break;
								}
							}
							if(slobodna) { {
								if(shDTO.getNumberOfPeople() >= r.getBeds() && shDTO.getNumberOfPeople() <=r.getPeople_capacity()) {
									imaSlob = true;
									break;
								}
							}
							}
						}
					}
					if(imaSlob) {
						hotelKraj.add(h);
					}
				}
			}
			List<HotelDTO> hoteli = new ArrayList<HotelDTO>();
			if(hotelKraj.size() > 0) {
				for(Hotel h : hotelKraj) {
					hoteli.add(new HotelDTO(h));
				}
			}
			return new ResponseEntity<>(hoteli, HttpStatus.OK);
		} else if (city.size() > 0 && hotels.size() > 0) {
			List<Hotel> hotelKraj = new ArrayList<Hotel>();
			for(City c : city) {
				List<Hotel> ho = hotelService.findByCity(c.getId());
				for(Hotel h : ho) {
					List<Room> rooms = roomService.findByHotel(h.getId());
					boolean imaSlob = false;
					
					for(Room r : rooms) {
						boolean slobodna = false;
						
						if(r.getHotel_res().isEmpty()) {
							imaSlob = true;
							break;
						} else {
							for(HotelReservation hr : r.getHotel_res()) {
								if(((hr.getArrival_date()).after(shDTO.getCheckin()) && (hr.getArrival_date()).before(shDTO.getCheckout())) || ((shDTO.getCheckin()).after(hr.getArrival_date()) && (shDTO.getCheckin()).before(hr.getDeparture_date())) || ((shDTO.getCheckout()).after(hr.getArrival_date()) && (shDTO.getCheckout()).before(hr.getDeparture_date()))) {
									slobodna = false;
								} else {
									slobodna = true;
									break;
								}
							}
							if(slobodna) { {
								if(shDTO.getNumberOfPeople() >= r.getBeds() && shDTO.getNumberOfPeople() <=r.getPeople_capacity()) {
									imaSlob = true;
									break;
								}
							}
							}
						}
					}
					if(imaSlob) {
						hotelKraj.add(h);
					}
				}
			}
			for(Hotel h : hotels) {
				List<Room> rooms = roomService.findByHotel(h.getId());
				boolean imaSlob = false;
				
				for(Room r : rooms) {
					boolean slobodna = false;
					
					if(r.getHotel_res().isEmpty()) {
						imaSlob = true;
						break;
					} else {
						for(HotelReservation hr : r.getHotel_res()) {
							if(((hr.getArrival_date()).after(shDTO.getCheckin()) && (hr.getArrival_date()).before(shDTO.getCheckout())) || ((shDTO.getCheckin()).after(hr.getArrival_date()) && (shDTO.getCheckin()).before(hr.getDeparture_date())) || ((shDTO.getCheckout()).after(hr.getArrival_date()) && (shDTO.getCheckout()).before(hr.getDeparture_date()))) {
								slobodna = false;
							} else {
								slobodna = true;
								break;
							}
						}
						if(slobodna) { {
							if(shDTO.getNumberOfPeople() >= r.getBeds() && shDTO.getNumberOfPeople() <=r.getPeople_capacity()) {
								imaSlob = true;
								break;
							}
						}
						}
					}
					
				}
				if(imaSlob) {
					boolean pom = false;
					for(Hotel temp : hotelKraj) {
						if(temp.getId().equals(h.getId())) {
							pom = true;
							break;
						}
					}
					if(!pom) {
						hotelKraj.add(h);
					}
				}
			}
			List<HotelDTO> hoteli = new ArrayList<HotelDTO>();
			if(hotelKraj.size() > 0) {
				for(Hotel h : hotelKraj) {
					hoteli.add(new HotelDTO(h));
				}
			}
			return new ResponseEntity<>(hoteli, HttpStatus.OK);
		} else {
			List<HotelDTO> hoteli = new ArrayList<HotelDTO>();
			return new ResponseEntity<>(hoteli, HttpStatus.OK);
		}
		
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
	//@PreAuthorize("hasRole('HOTEL_ADMIN')")
	public ResponseEntity<UslugaDTO> saveUsluga(@RequestBody UslugaDTO uslugaDTO, @PathVariable("id") Long id) {
		Hotel h = hotelService.findOneById(id);
		
		if (h == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Usluga usl = new Usluga();
		usl.setName(uslugaDTO.getName());
		usl.setPrice(uslugaDTO.getPrice());
		usl.setCharge(uslugaDTO.getCharge());
		usl.setDiscount(uslugaDTO.getDiscount());
		usl.setHotel(h);
		
		Set<Usluga> usluge = h.getUsluge();
		usluge.add(usl);
		
		usl = uslugaService.save(usl);
		
		return new ResponseEntity<>(new UslugaDTO(usl), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/{idHot}/service/{idSer}", method=RequestMethod.DELETE)
	//@PreAuthorize("hasRole('HOTEL_ADMIN')")
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
	//@PreAuthorize("hasRole('HOTEL_ADMIN')")
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
		    if (us.getId().equals(uslugaDTO.getId())) {
		        us.setName(uslugaDTO.getName());
		        us.setPrice(uslugaDTO.getPrice());
		        us.setCharge(uslugaDTO.getCharge());
		        us.setDiscount(uslugaDTO.getDiscount());
		        break;
		    }
		}
		
		Usluga usl = uslugaService.findOneById(uslugaDTO.getId());
		usl.setName(uslugaDTO.getName());
		usl.setPrice(uslugaDTO.getPrice());
		usl.setCharge(uslugaDTO.getCharge());
		usl.setDiscount(uslugaDTO.getDiscount());
		
		usl = uslugaService.save(usl);
		
		return new ResponseEntity<UslugaDTO>(new UslugaDTO(usl),HttpStatus.CREATED);
	}
	
	@RequestMapping(value = "/room/{id}", method = RequestMethod.POST, consumes = "application/json")
	//@PreAuthorize("hasRole('HOTEL_ADMIN')")
	public ResponseEntity<RoomDTO> saveRoom(@RequestBody RoomDTO roomDTO, @PathVariable("id") Long id) {
		Hotel h = hotelService.findOneById(id);
		
		if (h == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Room r = new Room();
		r.setName(roomDTO.getName());
		r.setBeds(roomDTO.getBeds());
		r.setFloor(roomDTO.getFloor());
		r.setPeople_capacity(roomDTO.getPeople_capacity());
		r.setPrice(roomDTO.getPrice());
		r.setBalcony(roomDTO.getBalcony());
		r.setHotel(h);
		
		Set<Room> sobe = h.getRooms();
		sobe.add(r);
		
		r = roomService.save(r);
		
		return new ResponseEntity<>(new RoomDTO(r), HttpStatus.CREATED);
	}
	
	@RequestMapping(value="/room/{id}", method=RequestMethod.PUT, consumes="application/json")
	//@PreAuthorize("hasRole('HOTEL_ADMIN')")
	public ResponseEntity<RoomDTO> updateRoom(@RequestBody RoomDTO roomDTO, @PathVariable("id") Long id) {
		
		Hotel h = hotelService.findOneById(id);
		
		if (h == null) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}
		
		Set<Room> rooms = h.getRooms();
		Iterator<Room> itr = rooms.iterator();
		
		while (itr.hasNext())
		{
		    Room ro = itr.next();
		    if (ro.getId().equals(roomDTO.getId())) {
		    	ro.setName(roomDTO.getName());
				ro.setBeds(roomDTO.getBeds());
				ro.setFloor(roomDTO.getFloor());
				ro.setPeople_capacity(roomDTO.getPeople_capacity());
				ro.setPrice(roomDTO.getPrice());
				ro.setBalcony(roomDTO.getBalcony());
		        break;
		    }
		}
		Room r = roomService.findOneById(roomDTO.getId());
		r.setName(roomDTO.getName());
		r.setBeds(roomDTO.getBeds());
		r.setFloor(roomDTO.getFloor());
		r.setPeople_capacity(roomDTO.getPeople_capacity());
		r.setPrice(roomDTO.getPrice());
		r.setBalcony(roomDTO.getBalcony());
		
		r = roomService.save(r);
		
		return new ResponseEntity<RoomDTO>(new RoomDTO(r),HttpStatus.CREATED);
	}
	
	//ALL hotel rooms
	@RequestMapping(value = "/{hotelId}/rooms", method = RequestMethod.GET)
	public ResponseEntity<List<RoomDTO>> getHotelRooms(@PathVariable Long hotelId) {
		
		Hotel hotel = hotelService.findOneById(hotelId);
		if(hotel == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Set<Room> rooms = hotel.getRooms();
		List<RoomDTO> roomDTO = new ArrayList<>();
		for(Room r : rooms) {
			roomDTO.add(new RoomDTO(r));
		}
		
		return new ResponseEntity<>(roomDTO, HttpStatus.OK);
	}
	
	//get ALL FREE rooms
	@RequestMapping(value = "/{hotelId}/freeRooms", method = RequestMethod.GET)
	public ResponseEntity<List<RoomDTO>> getHotelFreeRooms(@PathVariable Long hotelId) {
		
		Hotel hotel = hotelService.findOneById(hotelId);
		if(hotel == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Set<Room> rooms = hotel.getRooms();
		List<RoomDTO> roomDTO = new ArrayList<>();
		for(Room r : rooms) {
			roomDTO.add(new RoomDTO(r));
		}
		
		return new ResponseEntity<>(roomDTO, HttpStatus.OK);
	}
	
	//ONE hotel room
	@RequestMapping(value = "/room/{rid}", method = RequestMethod.GET)
	public ResponseEntity<RoomDTO> getHotelRoom(@PathVariable("rid") Long rid) {
		
		Room r = roomService.findOneById(rid);
		
		if(r == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		RoomDTO roomDTO = new RoomDTO(r);
		
		return new ResponseEntity<>(roomDTO, HttpStatus.OK);
	}
		
	@RequestMapping(value="/{idH}/room/{idR}", method=RequestMethod.DELETE)
	//@PreAuthorize("hasRole('HOTEL_ADMIN')")
	public ResponseEntity<Void> deleteRoom(@PathVariable("idH") Long idH, @PathVariable("idR") Long idR) {
		
		Hotel hotel = hotelService.findOneById(idH);
		
		if(hotel == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		Room r = roomService.findOneById(idR);
		
		if(r == null) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
		roomService.remove(idR);
		
		Set<Room> rooms = hotel.getRooms();
		Iterator<Room> itr = rooms.iterator();
		while (itr.hasNext())
		{
		    Room ro = itr.next();
		    if (ro.getId().equals(idR)) {
		        itr.remove();
		        break;
		    }
		}
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
