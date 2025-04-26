package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.Employee;
import com.nt.repository.IEmployeeRepository;

@Service("empservice")
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {

	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public List<Employee> getAllEmployees() {
		return repo.findAll();
	}

}
