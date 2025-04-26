package com.nt.service;

import java.util.List;

import com.nt.entity.Customer;

public interface IOToMOperationService {

	public void saveDataUsingCustomer();
	
	public void saveDataUsingPhoneNumber();
	
	public void getDataUsingCustomer();
	
	public void getDataUsingPhoneNumber();
	
	public void deleteDataUsingCustomer(int id);
}
