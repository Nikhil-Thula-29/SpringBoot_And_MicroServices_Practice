package com.nt.runner;

import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Employee;
import com.nt.service.IEmployeeManagementService;


@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeManagementService serv;
	
	@Override
	public void run(String... args) throws Exception {
		try {
			Employee emp=new Employee(new Random().nextInt(100000),"kiran","hyd",650000.0,true);
			String msg=serv.registerEmployee(emp);
			System.out.println(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
