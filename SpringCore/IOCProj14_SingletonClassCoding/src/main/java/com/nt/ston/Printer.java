package com.nt.ston;

public class Printer {

	public static Printer INSTANCE;
	
	public Printer() {
		System.out.println("0-PARAM CONSTRUCTOR");
	}
	
	//This code makes object creation only one time
	//But this is not the perfect single ton class.
	public static Printer getInstance() {
		if(INSTANCE==null) {
			INSTANCE=new Printer();
		}
		return INSTANCE;
	}


	
}
