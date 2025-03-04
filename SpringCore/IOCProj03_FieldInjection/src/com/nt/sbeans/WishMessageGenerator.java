package com.nt.sbeans;


//Field injection

import java.time.LocalDateTime;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
	
	//This is field Injection which is best injection and industry recomended
	//Has-a-property
	
	@Autowired
	private LocalDateTime ldt;
	@Autowired	
	private Date dt;
	
	
	public String generateWishMessage(String user) {
		int hour=ldt.getHour();
		if(hour<12) {
			return "Good Morning.. "+user+ " "+dt;
		}else if(hour>=12 && hour<16) {
			return "Good Evening "+user+ " "+dt;
		}else {
			return "Good night "+user+" "+dt;
		}
	}
	
	
	

}
