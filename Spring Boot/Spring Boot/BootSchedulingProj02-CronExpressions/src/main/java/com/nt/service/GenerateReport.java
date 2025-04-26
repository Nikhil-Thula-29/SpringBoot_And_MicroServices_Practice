package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GenerateReport {

	
	//point of time
	//@Scheduled(cron="20 * * * * *")
	//@Scheduled(cron="10 7,9 * * * *")	//7 and 9 min
	@Scheduled(cron="5 10-13 * * * *")	//from 10 to 13 min
//	public void generateReport1() {
//		System.out.println("Sales report on::"+new Date());
//	}
	
	
	//period of time
	@Scheduled(cron="10/20 * * * * *")	
	public void generateReport1() {
		System.out.println("Sales report on::"+new Date());
	}
	
	//read the notes for cron expression
}
