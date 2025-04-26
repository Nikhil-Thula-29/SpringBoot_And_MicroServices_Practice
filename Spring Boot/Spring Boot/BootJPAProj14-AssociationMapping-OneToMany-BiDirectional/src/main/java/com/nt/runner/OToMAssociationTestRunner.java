package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.service.IOToMOperationService;

@Component
public class OToMAssociationTestRunner implements CommandLineRunner {

	@Autowired
	private IOToMOperationService serv;
	
	@Override
	public void run(String... args) throws Exception {
		//save the data using parent
		//serv.saveDataUsingCustomer();
		
		//save the data using child
		//serv.saveDataUsingPhoneNumber();
		
		//get the data by parent customer
		//serv.getDataUsingCustomer();

		
		//get the data by child phoneNumber
		//serv.getDataUsingPhoneNumber();
		
		//delete data by customer
		//serv.deleteDataUsingCustomer(152);
	}

}
