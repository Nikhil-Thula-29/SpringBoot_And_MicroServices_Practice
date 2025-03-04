package com.nt.sbeans;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


//com.nt. i.e dot(.) is used for classes means packages
//com/nt/ i.e slash(/) is used for files like property,xml etc.
@Component("wmg")
public class WishMessageGenerator {
	
	@Autowired
	private LocalDateTime ldt;
	
	public String generatewishmessage(String user) {
		int hour=ldt.getHour();
		if(hour<12) {
			return "Good Morning:: "+user;
		}
		else if(hour<16) {
			return "Good Afternoon:: "+user;
		}
		else if(hour<20) {
			System.out.println(hour);
			return "Good Evening:: "+user;
		}
		else {
			return "Good Night:: "+user;
		}
	}

}
