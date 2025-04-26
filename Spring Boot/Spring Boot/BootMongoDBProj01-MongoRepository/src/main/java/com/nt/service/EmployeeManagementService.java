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
	public String[] registerEmployees(List<Employee> emps) {
		List<Employee> emplist=repo.saveAll(emps);
		String idVal[]= new String[emps.size()];
		for(int i=0;i<idVal.length;i++) {
			idVal[i]=emplist.get(i).getId();
		}
		return idVal;
	}

	@Override
	public List<Employee> showAllEmployees() {
		return repo.findAll();
	}

	@Override
	public Employee findEmployeeById(String id) {
		Optional<Employee> opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}else {
			throw new IllegalArgumentException("Invalid Id");
		}
	}

	@Override
	public String updateEmployeeById(String id, double newSalary) {
		Optional<Employee> opt=repo.findById(id);
		if(opt.isPresent()) {
			//get the document
			Employee emp=opt.get();
			emp.setSalary(newSalary);
			String idVal=repo.save(emp).getId();
			return idVal+" id document is updated with new salary.";
		}else {
			return id+" id document is not found.";
		}
	}
	

}
