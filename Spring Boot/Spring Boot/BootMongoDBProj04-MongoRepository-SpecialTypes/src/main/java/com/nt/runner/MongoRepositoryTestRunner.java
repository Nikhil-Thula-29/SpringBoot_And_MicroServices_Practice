package com.nt.runner;

import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

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
		/*try {
			Properties prop=new Properties();
			prop.put("voterId", 55464569);
			prop.put("aadharId",65351535);
			Employee emp=new Employee(1001,"Ajay","wgl",68000.0,
						    new String[] {"pink","yellow"},
						    List.of("kiran","sharan"),
						    Set.of(66666666L,356551565L,352131355L),
						    prop,
						    Map.of(55155,"Jeevan Anand")
						    );
			System.out.println(serv.registerEmployee(emp));
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		serv.showAllEmployess().forEach(System.out::println);
			
	}

}
