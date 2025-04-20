package com.nt;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class BootSchedulingProj02CronExpressionsApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootSchedulingProj02CronExpressionsApplication.class, args);
		System.out.println("BootSchedulingProj02CronExpressionsApplication.main()"+" start at "+new Date());
	}

}
