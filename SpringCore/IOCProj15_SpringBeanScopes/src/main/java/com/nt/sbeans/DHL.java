package com.nt.sbeans;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component("dhl")
@Primary		//for solving ambiguty problem. 		
public class DHL implements Courier {

	public DHL() {
		System.out.println("DHL.DHL()");
	}

	@Override
	public String deliver(int oid) {
		return "Your order id "+oid+" has been delivered through DHL courier service";
	}

}
