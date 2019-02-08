package com.bff.flylivedrive.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.bff.flylivedrive.model.FastResVehicle;
import com.bff.flylivedrive.model.Vozilo;

public class FastResVehicleDTO {
	
	private Long id;
	private Date startDate;
	private Date endDate;
	private Set<VoziloDTO> voziloDTO;
	private int discount;
	
	
	public FastResVehicleDTO() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public FastResVehicleDTO(Long id,Date startDate, Date endDate, Set<VoziloDTO> voziloDTO, int discount) {
		super();
		this.setId(id);
		this.startDate = startDate;
		this.endDate = endDate;
		this.voziloDTO = voziloDTO;
		this.discount = discount;
	}
	
	public FastResVehicleDTO  getDTO(FastResVehicle f) {
		Set<VoziloDTO> all = new HashSet<VoziloDTO>();
		for(Vozilo v: f.getVozila()) {
			all.add(new VoziloDTO(v));
		}
		return new FastResVehicleDTO(f.getId(),f.getStartDate(),f.getEndDate(), all, f.getDiscount());
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
	
	public Set<VoziloDTO> getVoziloDTO() {
		return voziloDTO;
	}
	
	public void setVoziloDTO(Set<VoziloDTO> voziloDTO) {
		this.voziloDTO = voziloDTO;
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
