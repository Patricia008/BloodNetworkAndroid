package com.upt.cti.bloodnetwork.persistence.domain.dto;

import java.sql.Date;

public class DonationDTO {
	private String userId;
	private long placeId;
	private Date date;
	private Date nextDonation;
	private long quantity;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public long getPlaceId() {
		return placeId;
	}

	public void setPlaceId(long placeId) {
		this.placeId = placeId;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Date getNextDonation() {
		return nextDonation;
	}

	public void setNextDonation(Date nextDonation) {
		this.nextDonation = nextDonation;
	}

	public long getQuantity() {
		return quantity;
	}

	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}
}
