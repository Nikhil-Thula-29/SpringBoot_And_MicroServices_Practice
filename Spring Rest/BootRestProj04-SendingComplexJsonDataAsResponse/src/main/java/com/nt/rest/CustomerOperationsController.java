package com.nt.rest;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Company;
import com.nt.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {

	@GetMapping("/report")
	public ResponseEntity<Customer> showCustomerData(){
		Customer cust=new Customer();
		cust.setCno(1001);
		cust.setCname("Nikhil");
		cust.setCadd("Hyd");
		cust.setBillAmt(90000.0f);
		cust.setNickNames(new String[] {"chinnu","kanna","nanna"});
		cust.setFriends(List.of("ajay","kiran","vamshi"));
		cust.setPhoneNumbers(Set.of(9999999L,88888888L,666666666L));
		cust.setIdDetails(Map.of("aadhar",85465461,"pan",355135,"voter",165135));
		Company comp=new Company(100,"HCL","Bangalore",350);
		cust.setCompany(comp);
		cust.setDob(LocalDateTime.of(2001,07,29,6,7,10));
		cust.setIsIndian(true);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
		
	}
}
