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

import com.bff.flylivedrive.dto.FilijalaDTO;

@Entity
public class Filijala {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "name", nullable = false)
	String name;
	

	@Column(name = "address", nullable = false)
	String address;
	
	@Column(name = "city", nullable = false)
	String city;
	
	@Column(name = "country", nullable = false)
	String country;
	
	@Column(name = "description", nullable = true)
	String description;
	
	//filijala sadrzi lisu vozila, moze ih biti n
	@OneToMany(mappedBy = "filijala", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Vozilo> vozila = new HashSet<Vozilo>();
	
	
	//jedna filijala vezana je samo za jedan servis
	@ManyToOne(fetch = FetchType.EAGER)
	private RentACar servis;
	
	public Filijala() {
		
	}
	
	
	public Filijala(Long id, String name, String address, String city, String country, String description) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.country = country;
		this.description = description;
	}
	
	public Filijala(FilijalaDTO fDTO) {
		this(fDTO.getId(),fDTO.getName(),fDTO.getAddress(), fDTO.getCity(), fDTO.getCountry(), fDTO.getDescription());
	}

	public Long getId() {
		return id;
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

	public RentACar getServis() {
		return servis;
	}

	public void setServis(RentACar servis) {
		this.servis = servis;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Set<Vozilo> getVozila() {
		return vozila;
	}

	public void setVozila(Set<Vozilo> vozila) {
		this.vozila = vozila;
	}	 
	
	
}
