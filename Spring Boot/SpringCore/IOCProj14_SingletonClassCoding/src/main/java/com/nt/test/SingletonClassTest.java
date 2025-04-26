package com.nt.test;

import com.nt.ston.Printer;

public class SingletonClassTest {

	public static void main(String[] args) {
		Printer p1=Printer.getInstance();
		Printer p2=Printer.getInstance();
		System.out.println(p1.hashCode());
		System.out.println(p2.hashCode());

	}

}
