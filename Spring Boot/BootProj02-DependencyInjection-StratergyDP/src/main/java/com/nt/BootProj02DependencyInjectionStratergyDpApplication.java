package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.Vehicle;

@SpringBootApplication
public class BootProj02DependencyInjectionStratergyDpApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj02DependencyInjectionStratergyDpApplication.class, args);
		Vehicle veh=ctx.getBean("vehicle",Vehicle.class);
		veh.journey("Hyderabad", "Gujarat");
	}

}
