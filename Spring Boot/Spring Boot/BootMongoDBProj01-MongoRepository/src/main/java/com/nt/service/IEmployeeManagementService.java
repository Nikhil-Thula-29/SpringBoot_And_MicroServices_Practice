package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeManagementService {

	public String registerEmployee(Employee emp);
	
	public String[] registerEmployees(List<Employee> emps);
	
	public List<Employee> showAllEmployees();
	
	public Employee findEmployeeById(String id);
	
	public String updateEmployeeById(String id,double newSalary);
}
