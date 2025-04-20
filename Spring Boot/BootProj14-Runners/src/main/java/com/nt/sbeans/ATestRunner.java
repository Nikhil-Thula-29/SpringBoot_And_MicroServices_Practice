package com.nt.sbeans;

import java.util.Set;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;


@Component
public class ATestRunner implements ApplicationRunner {

	public ATestRunner() {
		System.out.println("ATestRunner Application");
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
