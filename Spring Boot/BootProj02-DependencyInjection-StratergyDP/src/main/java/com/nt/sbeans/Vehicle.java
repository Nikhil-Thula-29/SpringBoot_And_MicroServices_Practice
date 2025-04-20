package com.nt.sbeans;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;



//Can develop by application prop also loose coupling
@Component("vehicle")
public class Vehicle {

	@Autowired
	@Qualifier("petrol")
	private Engine engine;
	
	public void journey(String startpl,String endpl) {
		System.out.println("Vehicle journey");
		engine.start();
		System.out.println("Your journey has started from "+startpl);
		engine.stop();
		System.out.println("Your journey has reached to "+endpl);
	}
	
}
