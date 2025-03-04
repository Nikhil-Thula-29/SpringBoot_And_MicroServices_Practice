package com.nt.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.BankService;

public class MethodReplacerTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		BankService bnk=ctx.getBean("bank",BankService.class);
		System.out.println("proxy class obj name:: "+bnk.getClass()+"superclass :: "+bnk.getClass().getSuperclass());
		double intrst=bnk.calInterestAmount(10000,2, 12);
		System.out.println(intrst);
	}
}
