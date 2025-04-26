package com.nt.runners;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.controller.EmployeeController;
import com.nt.model.Employee;

@Component		//It is important to rem 
public class RealtimeDIRunner implements CommandLineRunner{

	@Autowired	
	private EmployeeController cont;
	
	
	@Override
	public void run(String... args) throws Exception {
		//invoke bussiness method
		try {
			List<Employee> list=cont.showEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			list.forEach(val->{
				System.out.println(val);
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
