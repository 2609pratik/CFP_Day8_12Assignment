package com.bridgelabz.addressbookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bridgelabz.addressbookapp.entity.addressBookModel;
@Repository
public interface addressBookRepository extends JpaRepository<addressBookModel, Integer>{

}
