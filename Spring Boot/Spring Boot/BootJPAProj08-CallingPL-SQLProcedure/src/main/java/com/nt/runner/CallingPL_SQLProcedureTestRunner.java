package com.nt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Customer;
import com.nt.service.ICustomerManagementService;


@Component
public class CallingPL_SQLProcedureTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerManagementService service;
	
	@Override
	public void run(String... args) throws Exception {
		List<Customer> list=service.getCustomerByBillAmountRange(1000, 100000);
		list.forEach(val->{
			System.out.println(val);
		});
	}

}
