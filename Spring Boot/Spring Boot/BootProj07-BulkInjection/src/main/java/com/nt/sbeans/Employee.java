package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("emp")
@Setter
@ConfigurationProperties(prefix="emp.data")
@ToString
public class Employee {
	
	private String name;
	private int id;
	private String addrs;
	private Float salary;

}
