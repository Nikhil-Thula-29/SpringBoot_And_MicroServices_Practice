package com.nt.runner;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepository;

@Component
public class MongoRepositoryTestRunner implements CommandLineRunner {

	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public void run(String... args) throws Exception {
		
		//Here we have taken object[] bcz we not fetching complete Employee obj so use Object[] to get required fields
		
		/*List<Object[]> list=repo.getEmpsDataByAddrs("wgl");
		list.forEach(val->{
			System.out.println(Arrays.toString(val));
		});*/
		
		
		/*List<Employee> list=repo.getEmpsFullDataByAddrs("wgl");
		list.forEach(val->{
			System.out.println(val);
		});*/
		
		//repo.getEmpsFulldataByNameAndAddrs("raja","wgl").forEach(System.out::println);
		
		repo.getEmpsFulldataByNameAndAddrs("raja","wgl").forEach(System.out::println);
		
		
		/*repo.getEmpsFullDataBySalary(10000.0, 90000.0).forEach(row->{
			System.out.println(Arrays.toString(row));
		});*/
		
	}

}
