package com.nt.sbeans;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import lombok.Data;

@Component("project")
@Data
public class Project {

	private Integer pid;	//Wraper type to store null not zero.
	private String pname;
	private String paddrs;
	private Integer size;
	
	
}
