package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("diesel")
public class DieselEngine implements Engine {
	
	
	public DieselEngine() {
		System.out.println("0-Param Diesel Engine");
	}

	@Override
	public void start() {
		System.out.println("Diesel Engine has started");

	}

	@Override
	public void stop() {
		System.out.println("Diesel Engine has Stopped");

	}

}
