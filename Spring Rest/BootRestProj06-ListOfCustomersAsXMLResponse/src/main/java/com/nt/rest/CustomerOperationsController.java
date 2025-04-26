package com.nt.rest;

import java.util.List;

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
	
	
	@GetMapping("/report1")
	public ResponseEntity<List<Customer>> showCustomerData1(){
		Customer cust1=new Customer(1001,"Raja","hyd",89.66f);
		Customer cust2=new Customer(1002,"Kiran","wgl",36.66f);
		Customer cust3=new Customer(1003,"Ajay","kgr",72.66f);
		Customer cust4=new Customer(1004,"Rajesh","adl",68.66f);
		List<Customer> list=List.of(cust1,cust2,cust3,cust4);
		return new ResponseEntity<List<Customer>>(list,HttpStatus.OK);
	}
	
}
