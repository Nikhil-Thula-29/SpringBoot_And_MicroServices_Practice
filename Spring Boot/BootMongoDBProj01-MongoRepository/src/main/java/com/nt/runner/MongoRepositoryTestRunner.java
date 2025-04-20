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
		//save
		/*try {
			Employee emp=new Employee(1001,"raja","wgl",90000.0,true);
			String msg=serv.registerEmployee(emp);
			System.out.println(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		//saveAll
		/*try {
			Employee emp1=new Employee(1002,"Vamshi","Karimnagar",100000.0,false);
			Employee emp2=new Employee();
			emp2.setEno(1003);
			emp2.setEname("suresh");
			emp2.setVaccinated(false);
			String idVal[]=serv.registerEmployees(List.of(emp1,emp2));
			System.out.println("saved docs id values are:: "+Arrays.toString(idVal));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		//findAll
		/*try {
			serv.showAllEmployees().forEach(emp->{
				System.out.println(emp);
			});		
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//findById
		/*try {
			Employee emp=serv.findEmployeeById("67e79a50f8719d0fa3362f8c");	
			System.out.println(emp);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		//update
		try {
			String msg=serv.updateEmployeeById("67e79eb2bc69633acfe167f2",120000.0);	//double .0 is imp
			System.out.println(msg);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
