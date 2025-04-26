package com.nt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariDataSource;



@Configuration
@ComponentScan(basePackages = "com.nt")
@ImportResource("com/nt/cfgs/applicationContext.xml")
@PropertySource("com/nt/commons/info.properties")
//Here I want to use property file data but I have configured already it in applicationContext.xml so use that I have two approaches 
//1. Value annotation or Environmental Variables as property file data will store in environment variables directly we can get from there.
public class AppConfig {

	// 1. By value annotation
	
	@Value("${jdbc.driver}")
	private String driver;
	@Value("${jdbc.url}")
	private String url;
	@Value("${jdbc.username}")
	private String username;
	@Value("${jdbc.password}")
	private String password;
	
	
	@Bean(name="hkDS")
	public HikariDataSource createDS() {
		HikariDataSource hkdb=new HikariDataSource();
		hkdb.setDriverClassName(driver);
		hkdb.setJdbcUrl(url);
		hkdb.setUsername(username);
		hkdb.setPassword(password);
		return hkdb;
	}
	
	//2.By Environment method
	
//	@Autowired
//	private Environment env;
//	
//	@Bean(name="hkDS")
//	public HikariDataSource createDS() {
//		HikariDataSource hkdb=new HikariDataSource();
//		hkdb.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
//		hkdb.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
//		hkdb.setUsername(env.getRequiredProperty("jdbc.username"));
//		hkdb.setPassword(env.getRequiredProperty("jdbc.password"));
//		return hkdb;
//	}
	
}
