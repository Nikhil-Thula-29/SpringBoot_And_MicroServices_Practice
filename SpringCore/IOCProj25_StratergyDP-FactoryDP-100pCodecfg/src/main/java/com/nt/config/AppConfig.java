package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

@Configuration
@ComponentScan(basePackages = "com.nt.sbeans")
@ImportResource(locations = "com/nt/cfgs/applicationContext.xml")
//@PropertySource("com/nt/commons/info.properties")
//Note:: ImportResource is used for importing xml files and PropertySource is used for property files.
public class AppConfig {

	//No @Bean tag due to no user defined classses
}
