package com.nt.sbeans;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component("bat")
public class CricketBat {
	
	public CricketBat() {
		System.out.println("Inside Cricket Bat");
	}
	
	
	public int runs() {
		return new Random().nextInt(300);
	}

}
