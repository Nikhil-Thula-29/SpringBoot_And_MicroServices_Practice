package com.nt;

import java.time.LocalDateTime;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;

import com.nt.sbeans.WishMessageGenerator;

@SpringBootApplication
//It is combination of 3 annotations==> @Cofiguration+@AutoConfiguration+@ComponentScan
//This main class only act as configuration class due to @configuration.
public class BootProj01DependencyInjectionApplication {
	
	
	@Bean(name="ldt")	//pre defined class
	public LocalDateTime createLDT() {
		return LocalDateTime.now();
	}

	public static void main(String[] args) {
		
		ApplicationContext ctx=SpringApplication.run(BootProj01DependencyInjectionApplication.class, args);
		//This ApplicationContext internally calls AnnotationConfig.... 
		System.out.println(ctx.getClass());
		WishMessageGenerator message=ctx.getBean("wmg",WishMessageGenerator.class);
		String result=message.genmessage("Nikhil Thula");
		System.out.println(result);
		((ConfigurableApplicationContext) ctx).close();
	}

}
