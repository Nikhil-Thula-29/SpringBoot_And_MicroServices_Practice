package com.main.processor;

import org.springframework.batch.item.ItemProcessor;
import org.springframework.stereotype.Component;

import com.main.entity.Employee;

@Component
public class Employeeprocessor implements ItemProcessor<Employee,Employee> {

	@Override
	public Employee process(Employee item) throws Exception {
		//cal gross and net sal
		if(item.getSalary()>=15000) {
		item.setGrosssal(item.getSalary()+item.getSalary()*0.4);
		item.setNetsal(item.getGrosssal()-item.getGrosssal()*0.2);
		return item;
		}
		return null;
	}

	
}
