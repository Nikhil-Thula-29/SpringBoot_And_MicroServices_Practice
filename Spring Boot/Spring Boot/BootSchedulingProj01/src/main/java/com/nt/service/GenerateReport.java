package com.nt.service;

import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class GenerateReport {

	//@Scheduled(initialDelay =2000,fixedDelay = 3000)
//	@Scheduled(fixedRate=5000)
//	public void showReport() {
//		System.out.println("report start on:"+new Date());
//		try {
//			Thread.sleep(15000);
//		}catch(Exception e){
//			e.printStackTrace();
//		}
//		System.out.println("report end: "+new Date());
//	}
	
	
	
	/*@Scheduled(fixedDelay=3000)
	public void showReport1() {
		System.out.println("report1 on start:: "+new Date()+"---"+Thread.currentThread());
	}
	
	@Scheduled(fixedDelay=4000)
	public void showRepor2() {
		System.out.println("report2 on start:: "+new Date()+"---"+Thread.currentThread());
	}*/
	
	//@Scheduled(cron="20 * * * * *")
	//@Scheduled(cron="10 7,9 * * * *")	//7 and 9 min
	@Scheduled(cron="5 10-13 * * * *")	//from 10 to 13 min
	public void generateReport1() {
		System.out.println("Sales report on::"+new Date());
	}
	
}
