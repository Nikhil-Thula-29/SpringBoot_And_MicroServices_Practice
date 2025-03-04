package com.nt.sbeans;

import java.util.Date;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;


//The main use of instantiation and destruction is to check whether we have injected proper objects or not this instantiation is called after injecting objects so that we can get to know..
//multipule inherite because of interfaces


@Component("voter")
@PropertySource("com/nt/commons/info.properties")
public class Voter{
	
	@Value("${voter.name}")
	private String name;
	@Value("${voter.age}")
	private Integer age;
	private Date dov;
	
	public Voter() {
		System.out.println("0:: param constructor");	
	}
	

	
	
	//b.logic
	public String checkvotingelg() {
		if(age<18) {
			return "Mr/Miss/Mrs."+name+" your age is "+age+" not eligible for voting "+dov;
		}else {
			return "Mr/Miss/Mrs."+name+" your age is "+age+" eligible for voting "+dov;
		}
	}
	
	//lifecycle methods
	
	@PostConstruct
	public void init() {
		dov=new Date();
		if(age==null || name==null || age<0) {
			throw new IllegalArgumentException("Invalid inputs are given for name or age or for both..");
		}
	}
	
	@PreDestroy
	public void destory() {
		name=null;
		age=null;
		dov=null;
	}
	
	
}
