package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import com.nt.model.Customer;

@Controller
public class CustomerOperationsController {

	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showCustomerRegistration(@ModelAttribute("cust") Customer cust) {
		return "customer_register";
	}
	
	
}
