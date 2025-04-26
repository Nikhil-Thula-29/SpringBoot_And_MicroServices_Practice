package com.nt.client;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.nt.config.AppConfig;
import com.nt.sbeans.BankService;

public class MethodReplacerTest {
	public static void main(String[] args) {
		AnnotationConfigApplicationContext ctx=new AnnotationConfigApplicationContext(AppConfig.class);
		BankService bnk=ctx.getBean("bank",BankService.class);
		System.out.println("proxy class obj name:: "+bnk.getClass()+"superclass :: "+bnk.getClass().getSuperclass());
		double intrst=bnk.calInterestAmount(10000,2, 12);
		System.out.println(intrst);
	}
}
