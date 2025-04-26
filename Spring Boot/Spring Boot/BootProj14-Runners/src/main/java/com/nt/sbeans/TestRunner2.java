package com.nt.sbeans;

import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;


@Component
@Order(1)
public class TestRunner2 implements ApplicationRunner {

	public TestRunner2() {
		System.out.println("TestRunner2 Application");
	}
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("Non-Optional args "+args.getNonOptionArgs());
		Set<String> name=args.getOptionNames();
		System.out.println("Optional args are:: ");
		for(String val:name) {
			System.out.println(val+"......"+args.getOptionValues(val));			
		}
		System.out.println("----------------");
	}

}
