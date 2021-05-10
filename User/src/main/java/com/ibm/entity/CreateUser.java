package com.ibm.entity;

import org.springframework.data.annotation.Id;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CreateUser {

	@Id
	private String id;

	@NotEmpty(message = "Name is Mandatory")
	private String name;

	@NotNull
	@Email(message = "Valid Email")
	private String emailId;

	@NotNull
	@NotBlank
	@Size(min = 5, max = 20)
	private String username;

	@NotNull
	@NotBlank
	@Size(min = 8, max = 30)
	private String password;

	@NotNull
	@NotBlank
	private String confirmPassword;

	@NotNull
	@Min(1000000000)
	@Max(9999999999L)
	private long mobileNumber;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public long getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(long mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {

		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}
}
