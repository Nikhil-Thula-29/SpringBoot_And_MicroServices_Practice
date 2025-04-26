package com.nt.service;

import java.util.List;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.Employee;

public interface IEmployeeManagementService {

	public List<Employee> fetchAllEmployees();
	
	public String registerEmployee(Employee emp);
	
	public Employee getEmployeeByNo(int no) throws EmployeeNotFoundException;
	
	public String updateEmployee(Employee emp);
	
	public String deleteEmployee(int no);
}
