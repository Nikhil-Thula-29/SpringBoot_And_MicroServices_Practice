package com.nt.client;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.nt.sbeans.PersonalInfo;

public class ValueAnnotationTest {

	public static void main(String[] args) {
		ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		PersonalInfo per=ctx.getBean("pinfo",PersonalInfo.class);
		System.out.println(per);

	}

}
