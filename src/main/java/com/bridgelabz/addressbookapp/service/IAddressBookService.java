package com.bridgelabz.addressbookapp.service;

import java.util.List;

import com.bridgelabz.addressbookapp.dto.addressBookDTO;
import com.bridgelabz.addressbookapp.entity.addressBookModel;

public interface IAddressBookService {
	public String addNewAddress(addressBookDTO data) ;
	public addressBookModel getAddressById(String token);
	public void deleteAddressById(String token);
	public void updateAddressById(addressBookModel data, int id);
	public List<addressBookModel> getAllAddress(String token);

}
