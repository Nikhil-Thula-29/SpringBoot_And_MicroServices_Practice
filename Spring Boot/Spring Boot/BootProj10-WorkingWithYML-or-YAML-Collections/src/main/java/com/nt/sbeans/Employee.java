package com.nt.sbeans;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("emp")
@Data
@ConfigurationProperties(prefix="emp.details")	//for bulk injection
public class Employee {

	//Simple properties
	private Integer eno;
	private String ename;
	private String eaddrs;
	//Array Properties
	private String[] favcolors;
	//Collection properties
	private List<String> nickNames;
	private Set<Long> phoneNumbers;
	private Map<String,Long> idDetails;
	//HAS-A Propeties(object)
	private Project project;
	
}
