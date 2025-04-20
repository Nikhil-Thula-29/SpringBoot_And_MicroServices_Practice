package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empserv")
public class EmployeeManagementService implements IEmployeeManagementService{

	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public List<Employee> showEmployeesBySalaryRange(double startsal, double endsal) {
		List<Employee> emplist=repo.findBySalaryBetween(startsal, endsal);
		return emplist;
	}

	@Override
	public List<Employee> showEmployeesByEnames(String... names) {
		return repo.findByEnameIn(names);
	}

	

}
