package com.nt.runner;

import java.util.Arrays;
import java.util.List;

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
		/*List<Employee> list=serv.showEmployeesBySalaryRange(10000.0, 95000);
		list.forEach(System.out::println);*/
		
		
		serv.showEmployeesByEnames("Vamshi","raja").forEach(System.out::println);
	}

}
