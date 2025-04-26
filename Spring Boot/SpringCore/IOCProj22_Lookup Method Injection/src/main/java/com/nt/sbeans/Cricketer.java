package com.nt.sbeans;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Lookup;
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
public abstract class Cricketer{

	@Value("${cktr.id}")
	private Integer id;
	@Value("${cktr.name}")
	private String name;
	@Value("${cktr.jersyno}")
	private Integer jrsyno;

	//Here no need of writing 
	@Lookup
	public abstract CricketBat getruns();	//This method will be implemented by the IOC Container in the memory proxy class having depency lookup.
	
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
		CricketBat ckbat=getruns();
		int runs=ckbat.runs();
		System.out.println(name+" has scored "+runs+" runs.");
	}

	
}
