package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.Department;
import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj07BulkInjectionApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj07BulkInjectionApplication.class, args);
		Employee emp=ctx.getBean("emp",Employee.class);
		System.out.println("Employee Data:: "+emp);
		Department dept=ctx.getBean("dept",Department.class);
		System.out.println("Department Details are:: "+dept);
	}

}
