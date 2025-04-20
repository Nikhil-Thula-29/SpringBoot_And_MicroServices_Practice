package com.nt.service;

import java.util.List;

import com.nt.document.Employee;

public interface IEmployeeManagementService {

	public List<Employee> showEmployeesBySalaryRange(double startsal,double endsal);
	
	public List<Employee> showEmployeesByEnames(String... names);
}