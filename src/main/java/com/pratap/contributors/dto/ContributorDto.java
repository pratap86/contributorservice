package com.pratap.contributors.dto;

import java.io.Serializable;

public class ContributorDto implements Serializable {
	
	private static final long serialVersionUID = -491461820432610472L;
	
	private String contributorId;
	private String firstName;
	private String lastName;
	private String email;
	private String city;
	
	public ContributorDto() {
		
	}
	
	
	public ContributorDto(String contributorId, String firstName, String lastName, String email, String city) {
		this.contributorId = contributorId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.city = city;
	}


	public String getContributorId() {
		return contributorId;
	}
	public void setContributorId(String contributorId) {
		this.contributorId = contributorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
}
