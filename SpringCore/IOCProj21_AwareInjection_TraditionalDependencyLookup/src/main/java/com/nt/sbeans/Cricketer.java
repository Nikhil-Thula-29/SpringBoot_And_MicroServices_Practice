package com.nt.sbeans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component("crkt")
@PropertySource("com/nt/commons/info.properties")

//Note rem:: ApplicationContextAware 
//but this is not prefered due to conversion of invasive.
public class Cricketer implements ApplicationContextAware{

	@Value("${cktr.id}")
	private Integer id;
	@Value("${cktr.name}")
	private String name;
	@Value("${cktr.jersyno}")
	private Integer jrsyno;
	
	private ApplicationContext ctx;
	
	@Override
	public void setApplicationContext(ApplicationContext ctx) throws BeansException {
		System.out.println("In setApplicationContext");
		this.ctx=ctx;
		
	}
	
	
	public void bowling() {
		System.out.println(name+" is bowling");
	}
	
	public void fielding() {
		System.out.println(name+" is fielding");
	}
	
	public void keeping() {
		System.out.println(name+" is keeping");
	}
	
	
	public void batting() {
		//This code mainly for depency lookup to get the bat object for batting function so we have to create extra IOC container which is drawback
		//create an extra IOC Container 
		//ClassPathXmlApplicationContext ctx=new ClassPathXmlApplicationContext("com/nt/cfgs/applicationContext.xml");
		//getting obj through dependency lookup
		
		//Since the underlying container managed application context obj is injected so there is no need to create separate IOC Container here to perform dependency lookup. 
		CricketBat ckbat=(CricketBat)ctx.getBean("bat");
		int runs=ckbat.runs();
		System.out.println(name+" has scored "+runs+" runs.");
	}

	
}
