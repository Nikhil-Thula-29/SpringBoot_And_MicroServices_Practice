package com.main.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.nt.model.Employee;

@Component
public class EmployeeInfoItemProcessor implements ItemProcessor<Employee, Employee> {


	@Override
	public Employee process(Employee item) throws Exception {
		if(item.getSalary()>=50000) {
			item.setGrossSalary(item.getSalary()+item.getSalary()*0.4f);
			item.setNetSalary(item.getSalary()-item.getGrossSalary()*0.2f);
			System.out.println("Reading line: " + item);
			return item;
		}
		return null;
	}

}
