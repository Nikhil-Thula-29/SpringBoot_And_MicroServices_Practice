package com.nt.sbeans;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

//It is @component is imp
@Component
@Order(2)
public class TestRunner1 implements CommandLineRunner {
	
	public TestRunner1() {
		System.out.println("TestRunner1 CommandLine ");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("The Args are:: "+Arrays.toString(args));
		
		System.out.println("----------------");
	}

	
}

