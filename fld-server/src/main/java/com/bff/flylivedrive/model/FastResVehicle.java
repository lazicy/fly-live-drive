package com.bff.flylivedrive.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.bff.flylivedrive.dto.FastResVehicleDTO;

@Entity
@Table(name = "fast_res_vehicle")
public class FastResVehicle {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(name = "start_date", nullable = false)
	private Date startDate;
	
	@Column(name = "end_date", nullable = false)
	private Date endDate;
	
	@OneToMany(mappedBy = "fastRes", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private Set<Vozilo> vozila = new HashSet<Vozilo>();
	
	@Column(name = "discount", nullable = false)
	private int discount;

	public FastResVehicle() {
		super();
		// TODO Auto-generated constructor stub
	}
	

	public FastResVehicle(Long id,Date startDate, Date endDate, int discount) {
		super();
		this.id = id;
		this.startDate = startDate;
		this.endDate = endDate;
		this.discount = discount;
	}
	
	
	public FastResVehicle(FastResVehicleDTO dto) {
	}
	
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Set<Vozilo> getVozila() {
		return vozila;
	}

	public void setVozila(Set<Vozilo> vozila) {
		this.vozila = vozila;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}
	
}
