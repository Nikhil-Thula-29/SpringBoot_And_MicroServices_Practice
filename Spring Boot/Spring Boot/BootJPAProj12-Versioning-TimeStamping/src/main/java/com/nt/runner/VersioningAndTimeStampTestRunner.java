package com.nt.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.BankAccount;
import com.nt.service.IBankAccountManagementService;


@Component
public class VersioningAndTimeStampTestRunner implements CommandLineRunner{

	@Autowired
	private IBankAccountManagementService serv;
	
	@Override
	public void run(String... args) throws Exception {
		/*try {
			BankAccount account=new BankAccount("Nikhil",98000.0,99999888L);
			String msg=serv.createBankAccount(account);
		}catch(Exception e) {
			e.printStackTrace();
		}*/
		
		try {
			String msg=serv.updateAccountMobileNumber(10000000L,55555555L);
			System.out.println(msg);
			BankAccount account=serv.getAccountDetailsByAccno(10000000L);
			System.out.println("Account created on "+account.getCreationTime()+" lastely updated on:: "+account.getLastUpdationTime()+" updated for :: "+account.getUpdateCount()+" times.");
		}catch(Exception e) {
			e.printStackTrace();
		}
		

	}

}
