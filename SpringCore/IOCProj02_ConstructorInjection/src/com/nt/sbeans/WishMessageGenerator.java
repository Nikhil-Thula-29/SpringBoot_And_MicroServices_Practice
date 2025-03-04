package com.nt.sbeans;

//setter injection

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
	private LocalDateTime ldt;
	private Date dt;

	//In Constructor Injection we can use two constructor and two autowired annotation at a time it will error but we can use n number of parameter constructor 
	//but rem need to create bean tag for pre defined classes through xml.
	//We can not inject object to long,int types.
	
	@Autowired
	public WishMessageGenerator(LocalDateTime ldt,Date dt) {
		System.out.println("WishMessageGenerator.WishMessageGenerator()");
		this.ldt=ldt;
		this.dt=dt;
		
	}
	
	
	//This code gives error due to two constructors and autowired annotations in code 
	
	/*
	 * @Autowired public WishMessageGenerator(LocalDateTime ldt) {																
	 * System.out.println("WishMessageGenerator.WishMessageGenerator()");
	 * this.ldt=ldt;
	 * 
	 * }
	 */
	

	public String generateWishMessage(String user) {
		int hour=ldt.getHour();
		if(hour<12) {
			return "Good Morning.. "+user+dt;
		}else if(hour>=12 && hour<16) {
			return "Good Evening "+user+dt;
		}else {
			return "Good night "+user+dt;
			
		}
	}


	

}
