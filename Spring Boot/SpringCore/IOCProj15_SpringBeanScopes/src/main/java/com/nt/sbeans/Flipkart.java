package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("fp")
//@Scope("singleton")	//singleton is already default so even though we wont keep scope it is considered as singleton scope..
@Scope("prototype") //It is of prototype(no internal cache memory)
public class Flipkart {
	
	@Autowired
	private Courier courier;
	
	public Flipkart() {
		System.out.println("Flipkart.Flipkart()");
	}
	
	public String shopping(String items[],double prices[]) {
		double total=0;
		for(double p:prices) {
			total=total+p;
		}
		int oid=new Random().nextInt(1000);
		String msg=courier.deliver(oid);
		return Arrays.toString(items)+" are purchased having prices "+Arrays.toString(prices)+" ,bill amount "+total+msg;
	}

}
