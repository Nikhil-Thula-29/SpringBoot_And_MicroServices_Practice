package com.nt.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.entity.BankAccount;
import com.nt.repository.IBankAccountRepository;


@Service("bankservice")
public class BankAccountManagementServiceImpl implements IBankAccountManagementService{

	@Autowired
	private IBankAccountRepository repo;
	
	@Override
	public String createBankAccount(BankAccount account) {
		long accno=repo.save(account).getAccno();	
		return "Bank Account is opened having the account number:: "+accno;
	}

	@Override
	public String updateAccountMobileNumber(long accno, long newMobileNo) {
		Optional<BankAccount> opt=repo.findById(accno);
		if(opt.isPresent()) {
			BankAccount account=opt.get();
			account.setMobileNo(newMobileNo);
			repo.save(account);
			return accno+" bank account found and updated.";
		}else {
			return accno+" bank account not found.";
		}
		
	}

	@Override
	public BankAccount getAccountDetailsByAccno(Long accno) {
		return repo.getReferenceById(accno);		
	}

}
