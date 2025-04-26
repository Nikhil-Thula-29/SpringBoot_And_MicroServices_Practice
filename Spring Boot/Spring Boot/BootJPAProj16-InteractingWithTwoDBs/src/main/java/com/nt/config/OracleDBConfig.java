package com.nt.config;

import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.boot.orm.jpa.EntityManagerFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import jakarta.persistence.EntityManagerFactory;

//config class which contains beans def instead of xml

@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages="com.nt.repository.prod",	//linking repo
						entityManagerFactoryRef = "oraEMF",
						transactionManagerRef = "oraTxMgmr")

public class OracleDBConfig {

	//Datasource obj
	@Bean("oraDs")
	@ConfigurationProperties(prefix="ora.ds")
	@Primary
	public DataSource createOraDs() {
		return DataSourceBuilder.create().build();
	}
	
	//LocalContatinerEntityManagerFactoryBean that gives EntityManager object
	@Bean("oraEMF")
	@Primary	//placed bcz to get priority to our config orelse default like datasource hikari and other get priority due to autoconfig.
	public LocalContainerEntityManagerFactoryBean createLCEMFBForOracle(EntityManagerFactoryBuilder emBuilder) {
		//prepare HB properties
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("hibernate.dialect", "org.hibernate.dialect.OracleDialect");
		map.put("hibernate.hbm2ddl.auto", "update");
		map.put("hibernate.show_sql", "true");
		map.put("hibernate.format_sql", "true");
		
		//create LocalContainerEntityMangerFactoryBean class obj using EntityMangaerFactoryBuilder Object
		return emBuilder.dataSource(createOraDs()).packages("com.nt.entity.prod").properties(map).build();
	}
	
	@Bean("oraTxMgmr")
	@Primary
	public JpaTransactionManager createTxMgmForOracle(@Qualifier("oraEMF") EntityManagerFactory factory) {
		return new JpaTransactionManager(factory);
	}
	
}
