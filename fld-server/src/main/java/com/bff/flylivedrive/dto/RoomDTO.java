package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Room;

public class RoomDTO {
	
	private Long id;
	private String name;
	private int broj_kreveta;
	private int kapacitet_ljudi;
	private double cena;
	private int sprat;
	private boolean balkon;
	private boolean zauzeta;
	
	public RoomDTO() {
		
	}
	
	public RoomDTO(Room r) {
		this(r.getId(), r.getName(), r.getBroj_kreveta(), r.getKapacitet_ljudi(), r.getCena(), r.getSprat(), r.isBalkon(), r.isZauzeta());
	}
	
	public RoomDTO(Long id, String name, int broj_kreveta, int kapacitet_ljudi, double cena, int sprat, boolean balkon, boolean zauzeta) {
		super();
		this.id = id;
		this.name = name;
		this.broj_kreveta = broj_kreveta;
		this.kapacitet_ljudi = kapacitet_ljudi;
		this.cena = cena;
		this.sprat = sprat;
		this.balkon = balkon;
		this.zauzeta = zauzeta;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public int getBroj_kreveta() {
		return broj_kreveta;
	}
	public void setBroj_kreveta(int broj_kreveta) {
		this.broj_kreveta = broj_kreveta;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
	public int getSprat() {
		return sprat;
	}
	public void setSprat(int sprat) {
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getKapacitet_ljudi() {
		return kapacitet_ljudi;
	}

	public void setKapacitet_ljudi(int kapacitet_ljudi) {
		this.kapacitet_ljudi = kapacitet_ljudi;
	}
	
	
}
