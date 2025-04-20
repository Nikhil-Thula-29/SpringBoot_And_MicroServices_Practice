package com.nt.service;

import java.util.List;

import com.nt.model.Employee;

public interface IEmployeeManagementService {

	public List<Employee> fetchAllEmployees();
	
	public String registerEmployee(Employee emp);
	
	public Employee getEmployeeByNo(int no);
	
	public String updateEmployee(Employee emp);
	
	public String deleteEmployee(int no);
	
	public List<Integer> showAllDeptsNos();
	
	public boolean isDesignRejectList(String desg);
}
