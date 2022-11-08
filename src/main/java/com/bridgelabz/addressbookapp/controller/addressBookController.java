package com.bridgelabz.addressbookapp.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.addressbookapp.dto.addressBookDTO;
import com.bridgelabz.addressbookapp.dto.addressBookResponseDTO;
import com.bridgelabz.addressbookapp.entity.addressBookModel;
import com.bridgelabz.addressbookapp.service.IAddressBookService;

@RestController
public class addressBookController {
	@Autowired
	IAddressBookService service;
	@PostMapping("/create")
	public ResponseEntity<addressBookResponseDTO> addAddress(@RequestBody @Valid addressBookDTO data) {
		String token = service.addNewAddress(data);
		addressBookResponseDTO response = new addressBookResponseDTO("Address added", token);
		return new ResponseEntity<addressBookResponseDTO>(response,HttpStatus.OK);
	}
//eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1c2VyX2lkIjoyMn0.I6danKQEmrejeslJWQ5_iiWt0r1g9OQJp8CKyQyhVME
	
	@GetMapping("/getAll/{token}")
	public ResponseEntity<addressBookResponseDTO> getAll(@PathVariable String token) {
		List<addressBookModel> allAddress = service.getAllAddress(token); 
		addressBookResponseDTO response = new addressBookResponseDTO("All address below....!!", allAddress);
		return new ResponseEntity<addressBookResponseDTO> (response,HttpStatus.OK);
	}
	
	@GetMapping("/get/{token}")
	public ResponseEntity<addressBookResponseDTO> getById(@PathVariable String token) {
		addressBookModel allAddressById = service.getAddressById(token);
		addressBookResponseDTO response = new addressBookResponseDTO("Address below ", allAddressById);
		return new ResponseEntity<addressBookResponseDTO> (response,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{token}")
	public void deleteById(@PathVariable String token) {
		service.deleteAddressById(token);
	}
	
	@PutMapping("/update/{id}")
	public void updateById(@RequestBody @Valid addressBookModel data ,@PathVariable int id) {
		service.updateAddressById(data,id);
	}
	
}
