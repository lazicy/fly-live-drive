package com.bff.flylivedrive.dto;

import com.bff.flylivedrive.model.BonusPoints;

public class BonusPointsDTO {
	
	private Long id;
	private int points;
	private int discount;
	
	public BonusPointsDTO() {
		
	}
	
	public BonusPointsDTO(BonusPoints b) {
		this(b.getId(), b.getPoints(), b.getDiscount());
	}

	public BonusPointsDTO(Long id, int points, int discount) {
		this.id = id;
		this.points = points;
		this.discount = discount;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public int getPoints() {
		return points;
	}

	public void setPoints(int points) {
		this.points = points;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}
