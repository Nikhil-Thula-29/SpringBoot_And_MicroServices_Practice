package com.nt.sbeans;

//setter injection

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
	private LocalDateTime ldt;

	
	@Autowired
	public void setLdt(LocalDateTime ldt) {
		this.ldt = ldt;
	}

	
	
	public String generateWishMessage(String user) {
		int hour=ldt.getHour();
		if(hour<12) {
			return "Good Morning.. "+user;
		}else if(hour>=12 && hour<16) {
			return "Good Evening "+user;
		}else {
			return "Good night "+user;
		}
	}
	
	
	

}
