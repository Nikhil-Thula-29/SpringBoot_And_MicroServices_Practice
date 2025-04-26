package com.nt.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.Cricketer;

//If not understood leave it.

public class DependecnyLookupTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//Here cricketer is abstract class so no possible of creating object
		//so the IOC Container creates the object for this inmemory class and keeps in the internal cache.
		Cricketer ckter=(Cricketer) ctx.getBean("crkt");
		ckter.bowling();
		ckter.fielding();
		ckter.keeping();
		ckter.batting();
	}
}
