package com.bridgelabz.addressbookapp.dto;

import org.springframework.validation.annotation.Validated;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Validated
public class addressBookDTO {
//	@Pattern(regexp="[A-Z]{1}[a-z]{2,}$",message = "Enter correct name")
	private String fullName;
	//@NotEmpty(message = "Address cannot be empty")
	private String address;
//	@Pattern(regexp = "^[7-9]{1}[0-9]{9}" , message = "invalid mobile no")
	private long phoneNumber;
	//@NotNull(message = "Address cannot be empty")
	private String city;
	//@NotNull(message = "Address cannot be empty")
	private String state;
	//@Pattern(regexp = "[0-9]{6}", message = " Invalid zip code")
	private int zipCode;
//
	private String email;
	public addressBookDTO(String fullName, String address, long phoneNumber, String city, String state, int zipCode,
			String email) {
		super();
		this.fullName = fullName;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.email = email;
	}
	

}
