package com.nt.sbeans;

import org.springframework.stereotype.Component;

@Component("bank")
public class BankService {

	//When is not there then compound interest if offere is there then simple intreset.
	public double calInterestAmount(double pamt,double rate,double time) {
		System.out.println("Insdie callInterestAmount i.e compound interest");
		return (pamt*Math.pow(1+rate/100,time))-pamt;
	}
}
