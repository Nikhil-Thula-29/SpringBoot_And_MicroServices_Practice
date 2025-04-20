package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Setter;
import lombok.ToString;

@Component("dept")
@Setter
@ConfigurationProperties(prefix="dept.details")
@ToString
//variables and properties should match and setters are imp @configprop is setter injection
public class Department {

	private String name;
	private String location;
	private int no;
	private int size;
}
