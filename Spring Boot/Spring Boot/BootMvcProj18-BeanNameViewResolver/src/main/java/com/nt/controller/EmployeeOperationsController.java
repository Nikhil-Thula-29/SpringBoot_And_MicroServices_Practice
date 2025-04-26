package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.nt.entity.Employee;
import com.nt.service.IEmployeeManagementService;

@Controller
public class EmployeeOperationsController {

	@Autowired
	private IEmployeeManagementService serv;
	
	@GetMapping("/")
	public String showHome() {
		return "home";
	}
	
	//for pdf and excel report generation we wont use jsp as view resolver we use java classes as view resolver seein views 
	@GetMapping("/report")
	public String showReport(Map<String,Object> map,@RequestParam(name="type") String type) {
		List<Employee> list=serv.getAllEmployees();
		map.put("result", list);
		if(type.equalsIgnoreCase("excel")) {
			return "excel_report";
		}else {
		return "pdf_report";
		}
	}
}
