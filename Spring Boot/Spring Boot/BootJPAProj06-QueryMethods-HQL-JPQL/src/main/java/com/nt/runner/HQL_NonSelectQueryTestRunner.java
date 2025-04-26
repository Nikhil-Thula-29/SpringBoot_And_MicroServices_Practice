package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.ICustomerRepository;

@Component
public class HQL_NonSelectQueryTestRunner implements CommandLineRunner{

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
//		int count=repo.updateCustomerBillAmountByAddress(10,"hyd","gujarat");
//		System.out.println("no.of customers that are effected:: "+count);
		
		int count=repo.deleteCustomersByBillAmtRange(300000, 370000);
		System.out.println("no.of customers that are effected:: "+count);
		
	}

}
