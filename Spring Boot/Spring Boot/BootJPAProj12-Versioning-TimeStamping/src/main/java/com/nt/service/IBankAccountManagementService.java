package com.nt.service;

import com.nt.entity.BankAccount;

public interface IBankAccountManagementService {

	public String createBankAccount(BankAccount account);
	
	public String updateAccountMobileNumber(long accno,long newMobileNo);
	
	public BankAccount getAccountDetailsByAccno(Long accno);
}
