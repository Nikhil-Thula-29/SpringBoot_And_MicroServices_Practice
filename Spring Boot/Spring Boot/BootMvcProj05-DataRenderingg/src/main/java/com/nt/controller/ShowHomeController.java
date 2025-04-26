package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import com.nt.model.Employee;

@Controller
public class ShowHomeController {

	//simple values
	/*@GetMapping("/")
	public String showData(Map<String,Object> map) {
		//keep the data in model attribute
		map.put("name", "raja");
		map.put("age", 30);
		return "welcome";
	}*/
	
		//collections and arrays
		/*@GetMapping("/")
		public String showColl(Map<String,Object> map) {
			//keep the data in model attribute
			map.put("nickNames", new String[] {"king","raja","maharaja"});	//array content wont come in jsp direct check jsp
			map.put("friends",List.of("kiran","ajay","vinay"));
			map.put("phoneNumbers",Set.of(9512654,855465465,6858656));
			map.put("idDetails",Map.of("aadhar",98562,"pancard",98546554));
			return "welcome";
		}*/
	
	
	
	
	//model class object
	/*@GetMapping("/")
	public String showColl(Map<String,Object> map) {
		//keep the data in model attribute
		Employee emp=new Employee(101,"raja","hyd",900000.0);
		map.put("empsData", emp);
		return "welcome";
	}*/
	
	//model list
	@GetMapping("/")
	public String showColl(Map<String, Object> map) {
		// keep the data in model attribute
		Employee emp1 = new Employee(101, "raja", "hyd", 900000.0);
		Employee emp2 = new Employee(102, "rajesh", "vizag", 968000.0);
		Employee emp3 = new Employee(103, "anil", "wgl", 250000.0);
		Employee emp4 = new Employee(104, "kiran", "hyd", 600000.0);
		List<Employee> emplist=List.of(emp1,emp2,emp3,emp4);
		map.put("empslistData", emplist);
		return "welcome";
	}
}
