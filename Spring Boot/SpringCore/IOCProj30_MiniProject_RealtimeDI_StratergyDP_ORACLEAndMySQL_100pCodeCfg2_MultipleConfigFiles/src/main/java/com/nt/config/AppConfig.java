package com.nt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariDataSource;


//@Import tag is used for importing all config files in to appconfig same as import tag in xml.
@Configuration
@Import({ControllerConfig.class,PersistanceConfig.class,ServiceConfig.class})
//Here I want to use property file data but I have configured already it in applicationContext.xml so use that I have two approaches 
//1. Value annotation or Environmental Variables as property file data will store in environment variables directly we can get from there.

//In realtime proj there will many dao,service,controller clasess to separte them we have taken different persistanceconfig,serviceconfig,controllerconfge etc.

public class AppConfig {	
	
}
