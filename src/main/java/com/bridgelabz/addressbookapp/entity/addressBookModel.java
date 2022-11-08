package com.bridgelabz.addressbookapp.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.bridgelabz.addressbookapp.dto.addressBookDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
public class addressBookModel {
	@Id
	@GeneratedValue
	private int id;
	private String fullName;
	private String address;
	private long phoneNumber;
	private String city;
	private String state;
	private int zipCode;
	private String email;
	public addressBookModel(addressBookDTO data) {
		this.id = getId();
		this.fullName=data.getFullName();
		this.address=data.getAddress();
		this.phoneNumber=data.getPhoneNumber();
		this.city=data.getCity();
		this.state=data.getState();
		this.zipCode=data.getZipCode();
		this.email=data.getEmail();
	}
}
