package com.nt.sbeans;

//setter injection

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("wmg")
public class WishMessageGenerator {
	
	@Autowired
	//@Qualifier("ldt1")           //Best approach from ambiguty problem if 3 placed at a time Qualifier takes as priority
	private LocalDateTime ldt;

	

	
	
	public String generateWishMessage(String user) {
		int hour=ldt.getHour();
		if(hour<12) {
			return "Good Morning.. "+user+ldt;
		}else if(hour>=12 && hour<16) {
			return "Good Evening "+user+ldt;
		}else {
			return "Good night "+user+ldt;
		}
	}
	
	
	

}
