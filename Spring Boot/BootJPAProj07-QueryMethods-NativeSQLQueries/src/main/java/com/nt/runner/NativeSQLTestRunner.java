package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.repository.ICustomerRepository;

@Component
public class NativeSQLTestRunner implements CommandLineRunner {

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		int count=repo.insertCustomer("Sharan", "hyd", 89999.0);
		if(count==0) {
			System.out.println("Record not in inserted");
		}else {
			System.out.println("Record inserted");
		}
	}

}
