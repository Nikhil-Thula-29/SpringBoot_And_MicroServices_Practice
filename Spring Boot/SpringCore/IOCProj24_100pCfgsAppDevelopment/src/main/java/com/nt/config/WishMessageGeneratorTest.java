package com.nt.config;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.client.Appconfig;
import com.nt.sbeans.WishMessageGenerator;

public class WishMessageGeneratorTest {

	public static void main(String[] args) {
		//rem here we are using annotation not classpathxml or filepathxml 
		//Appconfig.class is not .class file it obj of java.lang.class of appconfig.
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(Appconfig.class);
		WishMessageGenerator wmg=ctx.getBean("wmg",WishMessageGenerator.class);
		String msg=wmg.generatewishmessage("Nikhil Thula");
		System.out.println(msg);
		

	}

}
