package com.nt.service;

import jakarta.mail.MessagingException;

public interface IPurchaseOrder {

	public String shopping(String items[],float prices[],String emails[]) throws MessagingException;
	
}
