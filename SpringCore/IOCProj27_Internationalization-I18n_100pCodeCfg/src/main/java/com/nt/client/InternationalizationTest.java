package com.nt.client;

import java.util.Locale;
import java.util.Scanner;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;

public class InternationalizationTest {

	public static void main(String[] args) {
		try (Scanner sc=new Scanner(System.in);
			AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		){
			
			System.out.println("Enter language code:: ");
			String lang=sc.nextLine();
			System.out.println("Enter Country code:: ");
			String country=sc.nextLine();
			//Prepare locale object having parameters(Locale(String language, String country, String variant))
			Locale loc=new Locale(lang,country);
			//get message from ioc container not getbean i.e getmessage
			//ctx.getmessage internally calls ctx.getbean("messageSource") which is fixed beanid
			String msg1=ctx.getMessage("wish.msg",new Object[]{},loc);
			String msg2=ctx.getMessage("bye.msg",new Object[]{},loc);
			System.out.println(msg1+ " "+msg2);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

}
