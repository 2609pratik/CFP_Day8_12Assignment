package com.bridgelabz.addressbookapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.addressbookapp.dto.addressBookDTO;
import com.bridgelabz.addressbookapp.entity.addressBookModel;
import com.bridgelabz.addressbookapp.exception.addressBookException;
import com.bridgelabz.addressbookapp.repository.addressBookRepository;
import com.bridgelabz.addressbookapp.util.EmailSenderService;
import com.bridgelabz.addressbookapp.util.TokenUtil;
@Service
public class addressBookService implements IAddressBookService {
	@Autowired
	addressBookRepository repo;
	@Autowired
	TokenUtil tokenUtil;
	@Autowired
	EmailSenderService sender;
	public List<addressBookModel> getAllAddress(String token) {
		int id = tokenUtil.decodeToken(token);
		Optional<addressBookModel> isAddressPresent = repo.findById(id);
		if (isAddressPresent.isPresent()) {
			List<addressBookModel> allAddress = repo.findAll();
			return   allAddress;
			
		} else {
			throw new addressBookException("exception...... no address found.");
		}		
	}
	public addressBookModel getAddressById(String token) {
		int id = tokenUtil.decodeToken(token);
		Optional<addressBookModel> isAddressPresent = repo.findById(id);
		if (isAddressPresent.isPresent()) {
			sender.sendEmail(isAddressPresent.get().getEmail(), "Address Book Application  ", isAddressPresent.get().getFullName()+ "\nWelcome to address book application\nYour address detail is availabe on below link "+ "http://localhost:8080/get/" + token);
			return   isAddressPresent.get();
		} else {
			throw new addressBookException("exception...... no address found.");
		}
	}
	public void deleteAddressById(String token) {
		int id = tokenUtil.decodeToken(token);
		Optional<addressBookModel> isAddressPresent = repo.findById(id);
		if (isAddressPresent.isPresent()) {
			sender.sendEmail(isAddressPresent.get().getEmail(), "Address Book Application  ", isAddressPresent.get().getFullName()+ "\nWelcome to address book application \nYour address data has been removed successfully");
			repo.deleteById(id);			
		} else {
			throw new addressBookException("no address found to delete");
		}
	}
	public void updateAddressById(addressBookModel data, int id) {
		addressBookModel existData = repo.findById(id).get();
		existData.setFullName(data.getFullName());
		existData.setAddress(data.getAddress());
		existData.setPhoneNumber(data.getPhoneNumber());
		existData.setCity(data.getCity());
		existData.setState(data.getState());
		existData.setZipCode(data.getZipCode());
		existData.setEmail(data.getEmail());
		sender.sendEmail(existData.getEmail(), "Address Book Application  ", existData.getFullName()+ "\nWelcome to address book application \nYour address data has been updated");
		repo.save(existData);
	}
	@Override
	public String addNewAddress(addressBookDTO data) {
		addressBookModel newAddress = new addressBookModel(data);
		repo.save(newAddress);
		String token = tokenUtil.createToken(newAddress.getId());
		sender.sendEmail(newAddress.getEmail(), "Address Book Application ", newAddress.getFullName()+ "\nWelcome to address book application");
		return token;
	}
}
