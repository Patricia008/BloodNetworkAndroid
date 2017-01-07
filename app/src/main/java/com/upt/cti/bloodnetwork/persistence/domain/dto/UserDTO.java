package com.upt.cti.bloodnetwork.persistence.domain.dto;

public class UserDTO {
	private String email;
	private String password;
	private String name;
	private LatLongDTO location;
	private String bloodType;
	private int weight;
	
	public String getEmail() {
		return email;
	}

	public String getPassword() {
		return password;
	}

	public String getName() {
		return name;
	}
	
	public LatLongDTO getLocation() {
		return location;
	}

	public String getBloodType() {
		return bloodType;
	}

	public int getWeight() {
		return weight;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setLocation(LatLongDTO location) {
		this.location = location;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}
	
	
}
