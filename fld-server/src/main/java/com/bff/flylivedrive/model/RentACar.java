package com.bff.flylivedrive.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.bff.flylivedrive.dto.RentDTO;

@Entity
public class RentACar {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false)
	String name;
	
	@Column(name = "address", nullable = false)
	String address;
	
	@Column(name = "address_on_map", columnDefinition="TEXT", nullable = true)
	String addressOnMap;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	City city;
		
	@Column(name = "description", nullable = true)
	String description;
	
	//jedan servis sadrzi vise filijala
	@OneToMany(mappedBy = "servis", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Filijala> filijale = new HashSet<Filijala>();
	
	
	public RentACar() {
		
	}
	
	public RentACar(Long id, String name, String address, City city, String description, String addressOnMap) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.description = description;
		this.addressOnMap = addressOnMap;
	}

	public RentACar(RentDTO rent) {
		this(rent.getId(),rent.getName(),rent.getAddress(),new City(rent.getCityDTO()),rent.getDescription(),rent.getAddressOnMap());
	}
	
	public City getCity() {
		return city;
	}

	public void setCity(City city) {
		this.city = city;
	}
	
	public Long getId() {
		return id;
	}

	public Set<Filijala> getFilijale() {
		return filijale;
	}

	public void setFilijale(Set<Filijala> filijale) {
		this.filijale = filijale;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String adress) {
		this.address = adress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getAddressOnMap() {
		return addressOnMap;
	}

	public void setAddressOnMap(String addressOnMap) {
		this.addressOnMap = addressOnMap;
	}
	
	
}
