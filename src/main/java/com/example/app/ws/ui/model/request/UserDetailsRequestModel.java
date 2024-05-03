package com.example.app.ws.ui.model.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class UserDetailsRequestModel {

	@NotBlank(message = "firstName should not be null or empty")
	private String firstName;
	
	@NotNull(message = "lastname should not be null")
	@Size(min = 2, max=16, message = "lastName should be min of 2 characters and max of 16 characters")
	private String lastName;
	
	@NotNull(message = "email should not be null")
	@Email(message = "Please enter valid email")
	private String email;
	
	@NotNull(message = "password should not be null")
	@Size(min=8, max=18, message = "Password should be of min 8 characters and max 18 characters")
	private String password;
	
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
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	
}
