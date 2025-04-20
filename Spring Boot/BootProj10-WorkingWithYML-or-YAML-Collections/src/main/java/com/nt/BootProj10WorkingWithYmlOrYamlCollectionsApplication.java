package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.Employee;

@SpringBootApplication
public class BootProj10WorkingWithYmlOrYamlCollectionsApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj10WorkingWithYmlOrYamlCollectionsApplication.class, args);
		Employee emp=ctx.getBean("emp",Employee.class);
		System.out.println("Employee Details with YML are:: "+emp);
	}

}
