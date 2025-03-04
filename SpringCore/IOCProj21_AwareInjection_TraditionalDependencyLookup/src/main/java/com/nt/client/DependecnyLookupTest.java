package com.nt.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.Cricketer;

public class DependecnyLookupTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		Cricketer ckter=(Cricketer) ctx.getBean("crkt");
		ckter.bowling();
		ckter.fielding();
		ckter.keeping();
		ckter.batting();
	}
}
