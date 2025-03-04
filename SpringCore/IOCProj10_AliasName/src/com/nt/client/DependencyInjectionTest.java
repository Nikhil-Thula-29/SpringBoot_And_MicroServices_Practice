package com.nt.client;

import java.time.LocalDateTime;

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
		System.out.println("============Alias Id's===============");
		LocalDateTime dt=ctx.getBean("ldt",LocalDateTime.class);
		LocalDateTime dt1=ctx.getBean("ldt1",LocalDateTime.class);
		LocalDateTime dt2=ctx.getBean("ldt2",LocalDateTime.class);
		LocalDateTime dt3=ctx.getBean("ldt3",LocalDateTime.class);
		LocalDateTime dt4=ctx.getBean("ldt4",LocalDateTime.class);
		LocalDateTime dt5=ctx.getBean("ldt5",LocalDateTime.class);
		System.out.println(dt+ "  "+dt1+"   "+dt2+ "  "+dt3+"   "+dt4+"   "+dt5);
		ctx.close();
	}

}
