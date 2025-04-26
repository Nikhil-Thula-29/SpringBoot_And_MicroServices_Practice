package com.nt.sbeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("cng")
//@Primary
public class CNGEngine implements Engine {
	
	public CNGEngine() {
		System.out.println("0-param CNGEngine");
	}

	@Override
	public void start() {
		System.out.println("CNGEngine has Started");

	}

	@Override
	public void stop() {
		System.out.println("CNGEngine has Stopped");

	}

}
