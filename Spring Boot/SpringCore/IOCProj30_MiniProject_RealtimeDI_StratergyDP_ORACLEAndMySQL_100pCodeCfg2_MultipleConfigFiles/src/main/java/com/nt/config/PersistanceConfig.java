package com.nt.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import com.zaxxer.hikari.HikariDataSource;

@Configuration
@ComponentScan(basePackages = "com.nt.dao")
@PropertySource("com/nt/commons/info.properties")
public class PersistanceConfig {

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
		
//		@Autowired
//		private Environment env;
	//	
//		@Bean(name="hkDS")
//		public HikariDataSource createDS() {
//			HikariDataSource hkdb=new HikariDataSource();
//			hkdb.setDriverClassName(env.getRequiredProperty("jdbc.driver"));
//			hkdb.setJdbcUrl(env.getRequiredProperty("jdbc.url"));
//			hkdb.setUsername(env.getRequiredProperty("jdbc.username"));
//			hkdb.setPassword(env.getRequiredProperty("jdbc.password"));
//			return hkdb;
//		}
}
