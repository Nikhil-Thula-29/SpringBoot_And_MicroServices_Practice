package com.nt.sbeans;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("sf")
public class SeasonFinder {

	@Autowired
	private LocalDate ld;
	
	public String findseason(String user) {
		int month=ld.getMonthValue();
		if(month>=3 && month<=6) {
			return "Hot summer wishes to "+user;
		}
		else if(month>=7 && month<=10) {
			return "Drizziling monsoon wishes to "+user;
		}
		else {
			return "Winter season wishes to "+user;
		}
	}
	
}
