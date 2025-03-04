package com.nt.client;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.nt.sbeans.WishMessageGenerator;

public class DependencyInjectionTest {

	public static void main(String[] args) {
		FileSystemXmlApplicationContext ctx=new FileSystemXmlApplicationContext("src/com/nt/cfgs/applicationContext.xml");
		//System.out.println(Arrays.toString(ctx.getBeanDefinitionNames()));
		Object obj=ctx.getBean("wmg");
		WishMessageGenerator gen=(WishMessageGenerator)obj;
		String res=gen.generateWishMessage("Nikhil Thula");
		System.out.println(res);
		ctx.close();
	}

}
