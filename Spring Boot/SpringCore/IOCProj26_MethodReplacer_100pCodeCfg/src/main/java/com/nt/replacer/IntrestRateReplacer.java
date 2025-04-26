package com.nt.replacer;

import java.lang.reflect.Method;

import org.springframework.beans.factory.support.MethodReplacer;
import org.springframework.stereotype.Component;

@Component("irr")	
public class IntrestRateReplacer implements MethodReplacer{

	@Override
	public Object reimplement(Object obj, Method method, Object[] args) throws Throwable {
		//write here new logics calculating simple intrest amt
		//get the target method args values
		System.out.println("Simple intrest rate");
		double pamt=(double) args[0];
		double rate=(double) args[1];
		double time=(double) args[2];
		//cal simple intrest
		return (pamt*rate*time)/100;
	}

}
	 