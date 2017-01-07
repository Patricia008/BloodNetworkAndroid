package com.upt.cti.bloodnetwork.persistence.domain.dto;

public class DonationPlaceDTO {
	
	private long id;
	private String name;
	private LatLongDTO location;
	private OrganizationDTO organization;

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LatLongDTO getLocation() {
		return location;
	}

	public void setLocation(LatLongDTO location) {
		this.location = location;
	}

	public OrganizationDTO getOrganization() {
		return organization;
	}

	public void setOrganization(OrganizationDTO organization) {
		this.organization = organization;
	}
}
