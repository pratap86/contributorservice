package com.pratap.contributors.model;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "Mandatory details about contributor")
public class ContributorRequestModel {

	@NotNull(message="First name cannot be empty")
	@Size(min=2, message= "First name must not be less than two characters")
	@ApiModelProperty(notes = "First name must not be less than two characters")
	private String firstName;
	
	@NotNull(message="Last name cannot be empty")
	@Size(min=2, message= "Last name must not be less than two characters")
	@ApiModelProperty(notes = "Last name must not be less than two characters")
	private String lastName;
	
	@NotNull(message="Email must be valid")
	@Email
	@ApiModelProperty(notes = "emai must be valid")
	private String email;
	
	@NotNull(message = "city cannot be empty")
	@ApiModelProperty(notes = "city can not be valid")
	private String city;

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
