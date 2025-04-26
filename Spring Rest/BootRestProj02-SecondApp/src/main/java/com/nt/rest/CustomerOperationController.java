package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer-api")
public class CustomerOperationController {

	@GetMapping("/report")
	public ResponseEntity<String> showCustomersReport(){
		System.out.println("CustomerOperationsCOntroller.showCustomersReport()");
		return new ResponseEntity<String>("Reports Operation",HttpStatus.OK);
	}
	
	@PostMapping("/register")
	public ResponseEntity<String> registerCustomer(){
		System.out.println("CustomerOperationsCOntroller.registerCustomer()");
		return new ResponseEntity<String>("Customer registration Operation",HttpStatus.CREATED);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateCustomer(){
		System.out.println("CustomerOperationsCOntroller.updateCustomer()");
		return new ResponseEntity<String>("Customer update Operation",HttpStatus.OK);
	}
	
	@PatchMapping("/pupdate")
	public ResponseEntity<String> updateCustomerEmail(){
		System.out.println("CustomerOperationsCOntroller.updateCustomerEmail()");
		return new ResponseEntity<String>("Customer email update Operation",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCustomer(){
		System.out.println("CustomerOperationsCOntroller.delteCustomer()");
		return new ResponseEntity<String>("Customer delete Operation",HttpStatus.OK);
	}
}
