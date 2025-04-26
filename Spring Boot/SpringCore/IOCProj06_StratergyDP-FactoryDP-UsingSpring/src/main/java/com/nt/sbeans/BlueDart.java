package com.nt.sbeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("bDart")
//@Primary     //for solving ambiguty problem
public class BlueDart implements Courier{

	public BlueDart() {
		System.out.println("BlueDart.BlueDart()");
	}

	@Override
	public String deliver(int oid) {
		return "Your order id "+oid+" has been delivered through BlueDart courier service";
	}
}
