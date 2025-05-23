package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("wmg")//bean id user defined class
public class WishMessageGenerator {
	
	@Autowired
	private LocalDateTime ldt;
	
	public String genmessage(String user) {
		int hour=ldt.getHour();
		if(hour<12) {
			return "Good Morning "+user;
		}
		else if(hour<16) {
			return "Good Afternoon "+user;
		}
		else if(hour<20) {
			return "Good Evening "+user;
		}
		else {
			return "Good Night "+user;
		}
	}
	

}
