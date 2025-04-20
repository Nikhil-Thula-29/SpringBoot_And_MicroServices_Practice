package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeManagementService {

	public String registerEmployee(Employee emp);
	
	public List<Employee> showAllEmployess();
}
