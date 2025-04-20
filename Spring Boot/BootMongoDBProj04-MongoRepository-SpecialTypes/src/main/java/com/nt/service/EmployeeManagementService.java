package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.document.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empserv")
public class EmployeeManagementService implements IEmployeeManagementService{

	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public String registerEmployee(Employee emp) {
		String idVal=repo.save(emp).getId();
		return "employee is registered with the id value:: "+idVal;
	}

	@Override
	public List<Employee> showAllEmployess() {
		return repo.findAll();
	}

}
