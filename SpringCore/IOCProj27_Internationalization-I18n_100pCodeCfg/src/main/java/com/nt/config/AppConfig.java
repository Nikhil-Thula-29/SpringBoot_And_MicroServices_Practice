package com.nt.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

@Configuration
@ComponentScan(basePackages = "com.nt") //We can separete it by commas i.e packages "com.nt","com.st" example only.
public class AppConfig {

	//Write any pre-defined classes in configuration file
	//Imp:: As we know we only have to create object for @Bean but in xml bean tag ioc only creates object also rem this point.
	
	@Bean("messageSource")	//fixed Bean Id
	public ResourceBundleMessageSource createRBMS() {
		ResourceBundleMessageSource rms=new ResourceBundleMessageSource();
		rms.setBasename("com/nt/commons/App");
		return rms;
	}
}
