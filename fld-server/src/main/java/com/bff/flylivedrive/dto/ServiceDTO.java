package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.Usluga;

public class ServiceDTO {
	
	private Long id;
	private String naziv;
	private double cena;
	
	public ServiceDTO() {
		
	}
	
	public ServiceDTO(Usluga s) {
		this(s.getId(), s.getNaziv(), s.getCena());
	}
	
	public ServiceDTO(Long id, String naziv, double cena) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.cena = cena;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNaziv() {
		return naziv;
	}
	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}
	public double getCena() {
		return cena;
	}
	public void setCena(double cena) {
		this.cena = cena;
	}
}
