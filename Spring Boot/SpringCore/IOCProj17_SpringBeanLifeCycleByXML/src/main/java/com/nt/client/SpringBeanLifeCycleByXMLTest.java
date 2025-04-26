package com.nt.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.Voter;

public class SpringBeanLifeCycleByXMLTest {
	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		Voter vt=(Voter) ctx.getBean("voter");
		System.out.println(vt.checkvotingelg());
	}
}
