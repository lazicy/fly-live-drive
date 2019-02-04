package com.bff.flylivedrive.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Room {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name="name", nullable = false)
	private String name;
	
	@Column(name="broj_kreveta", nullable = false)
	private Integer broj_kreveta;
	
	@Column(name="kapacitet_ljudi", nullable = false)
	private Integer kapacitet_ljudi;
	
	@Column(name="cena", nullable = false)
	private Double cena;
	
	@Column(name="sprat", nullable = false)
	private Integer sprat;
	
	@Column(name="balkon", nullable = false)
	private boolean balkon;
	
	@Column(name="zauzeta", nullable = false)
	private boolean zauzeta;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Hotel hotel;
	
	// Prosecna ocena i Ocene(OneToMany)
	
	public Room() {
		super();
		zauzeta = false;
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

	public Integer getBroj_kreveta() {
		return broj_kreveta;
	}

	public void setBroj_kreveta(Integer broj_kreveta) {
		this.broj_kreveta = broj_kreveta;
	}

	public Integer getKapacitet_ljudi() {
		return kapacitet_ljudi;
	}

	public void setKapacitet_ljudi(Integer kapacitet_ljudi) {
		this.kapacitet_ljudi = kapacitet_ljudi;
	}

	public Double getCena() {
		return cena;
	}

	public void setCena(Double cena) {
		this.cena = cena;
	}

	public Integer getSprat() {
		return sprat;
	}

	public void setSprat(Integer sprat) {
		this.sprat = sprat;
	}

	public boolean isBalkon() {
		return balkon;
	}

	public void setBalkon(boolean balkon) {
		this.balkon = balkon;
	}

	public boolean isZauzeta() {
		return zauzeta;
	}

	public void setZauzeta(boolean zauzeta) {
		this.zauzeta = zauzeta;
	}

	public Hotel getHotel() {
		return hotel;
	}

	public void setHotel(Hotel hotel) {
		this.hotel = hotel;
	}

}
