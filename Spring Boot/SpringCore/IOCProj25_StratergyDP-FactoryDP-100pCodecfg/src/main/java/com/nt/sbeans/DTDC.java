package com.nt.sbeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dtdc")
//@Primary			//for solving ambiguty problem
public class DTDC implements Courier {
	
	

	public DTDC() {
		System.out.println("DTDC.DTDC()");
	}

	@Override
	public String deliver(int oid) {
		return "Your order id "+oid+" has been delivered through DTDC courier service";
	}

}
