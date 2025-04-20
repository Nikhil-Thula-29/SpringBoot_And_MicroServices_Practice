package com.nt.sbeans;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

//It is @component is imp
@Component
public class ATestRunner1 implements CommandLineRunner {
	
	public ATestRunner1() {
		System.out.println("ATestRunner1 CommandLine ");
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("The Args are:: "+Arrays.toString(args));
		
		System.out.println("----------------");
	}

	
}

