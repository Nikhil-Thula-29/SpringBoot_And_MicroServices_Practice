package com.nt.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.exception.EmployeeNotFoundException;
import com.nt.model.Employee;
import com.nt.repository.IEmployeeRepository;


@Service("empservice")
public class EmployeeManagementServiceImpl implements IEmployeeManagementService {

	@Autowired
	private IEmployeeRepository repo;
	
	@Override
	public List<Employee> fetchAllEmployees() {
		return repo.findAll();
	}

	@Override
	public String registerEmployee(Employee emp) {
		int idVal=repo.save(emp).getEmpno();
		return "Employee is saved with idVal:: "+idVal;
	}

	@Override
	public Employee getEmployeeByNo(int no) throws EmployeeNotFoundException {
		Optional<Employee> opt=repo.findById(no);
		if(opt.isEmpty()) {
			throw new EmployeeNotFoundException("Employee is not found");
		}
		return opt.get();
	}

	@Override
	public String updateEmployee(Employee emp) {
		Optional opt=repo.findById(emp.getEmpno());
		if(opt.isPresent()) {
			repo.save(emp);
			return emp.getEmpno()+" employee is updated.";
		}
		
		return emp.getEmpno()+" employee is not available for updation";
	}

	@Override
	public String deleteEmployee(int no) {
		repo.deleteById(no);
		return "Employee is Deleted";
	}

}
