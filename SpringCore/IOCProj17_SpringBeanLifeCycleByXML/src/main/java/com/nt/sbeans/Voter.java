package com.nt.sbeans;

import java.util.Date;


//The main use of instantiation and destruction is to check whether we have injected proper objects or not this instantiation is called after injecting objects so that we can get to know..
public class Voter {
	private String name;
	private Integer age;
	private Date dov;
	
	public Voter() {
		System.out.println("Voter.Voter()");	
	}
	
	
	public void setName(String name) {
		this.name = name;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public void setDov(Date dov) {
		this.dov = dov;
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
	
	public void init() {
		dov=new Date();
		if(age==null || name==null || age<0) {
			throw new IllegalArgumentException("Invalid inputs are given for name or age or for both..");
		}
	}
	
	public void destory() {
		name=null;
		age=null;
		dov=null;
	}
	
}
