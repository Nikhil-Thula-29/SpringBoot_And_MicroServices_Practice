package com.nt;

import java.beans.PropertyVetoException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.env.Environment;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.nt.controller.EmployeeController;
import com.nt.model.Employee;

@SpringBootApplication
@ImportResource("com/nt/cfgs/applicationContext.xml")
public class BootProj05RealtimeDiRealtimeStratergyDpWithLooseCouplingApplication {
	
	
//	@Autowired
//	private Environment envi;
//	
//	
//	@Bean("c3P0")
//	public DataSource createC3P0DS() throws IllegalStateException, PropertyVetoException {
//		ComboPooledDataSource cds=new ComboPooledDataSource();
//		cds.setDriverClass(envi.getRequiredProperty("spring.datasource.driver-class-name"));
//		cds.setJdbcUrl(envi.getRequiredProperty("spring.datasource.url"));
//		cds.setUser(envi.getRequiredProperty("spring.datasource.username"));
//		cds.setPassword(envi.getRequiredProperty("spring.datasource.password"));
//		return cds;
//	}

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj05RealtimeDiRealtimeStratergyDpWithLooseCouplingApplication.class, args);
		EmployeeController controller=ctx.getBean("empController",EmployeeController.class);
		try {
			List<Employee> list=controller.showEmployeesByDesgs("CLERK", "MANAGER", "SALESMAN");
			list.forEach(emp->{
				System.out.println(emp);
			});
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		((ConfigurableApplicationContext) ctx).close();
		
	}

	
}
