package com.example.app.ws.ui.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UpdateUserDetailsRequestModel {
	
	@NotBlank(message = "firstName cannot be null or empty")
	private String firstName;
	
	@NotNull(message = "lastName cannot be null")
	@Size(min = 2, max=16, message = "lastName should be min of 2 characters and max of 16 characters")
	private String lastName;

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
}
