package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nt.model.Customer;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationsController {

	@GetMapping("/report")
	public ResponseEntity<Customer> showCustomerData(){
		Customer cust=new Customer(1001,"Raja","hyd",89.66f);
		return new ResponseEntity<Customer>(cust,HttpStatus.OK);
	}
}
