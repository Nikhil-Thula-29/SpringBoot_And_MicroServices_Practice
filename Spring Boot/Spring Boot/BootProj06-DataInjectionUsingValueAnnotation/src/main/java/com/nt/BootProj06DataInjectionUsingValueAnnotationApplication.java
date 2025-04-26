package com.nt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.nt.sbeans.HotelInfo;

@SpringBootApplication
public class BootProj06DataInjectionUsingValueAnnotationApplication {

	public static void main(String[] args) {
		ApplicationContext ctx=SpringApplication.run(BootProj06DataInjectionUsingValueAnnotationApplication.class, args);
		HotelInfo hi=ctx.getBean("hotel",HotelInfo.class);
		System.out.println(hi);
		System.out.println("Final Bill amount:: "+hi.caldis(200f));
	}

}

