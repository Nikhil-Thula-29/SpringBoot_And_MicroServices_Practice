package com.nt.client;

import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


//This is used as configuration class i.e component++, this is used instead of xml file
//This configuration file is like @component i,e appconfig object and bean obj.
@Configuration
@ComponentScan(basePackages ="com.nt")
public class Appconfig {
	
	
	@Bean(name="ldt")	//This bean tag which is user defined class to make it spring bean but we have to create obj opp to xml in xml we will not create <bean name="> obj for ldt.
	public LocalDateTime getldt() {
		return LocalDateTime.now();
	}

}
