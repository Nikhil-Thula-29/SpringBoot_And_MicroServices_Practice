package com.nt.sbeans;

import java.util.Arrays;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("fp")
public class Flipkart {
	
	@Autowired
	// @Qualifier("${courier.id}") //Invalid becoz we can place placeholders only in @value annoatation.
	@Qualifier("ekart")
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
