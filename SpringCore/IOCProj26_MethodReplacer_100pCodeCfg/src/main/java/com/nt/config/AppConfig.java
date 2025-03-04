package com.nt.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
@ComponentScan(basePackages = "com.nt")	//To scan in IntrestRateReplacer i.e component("irr") so take com.nt
@ImportResource(locations = "com/nt/cfgs/applicationContext.xml")
public class AppConfig {

}
