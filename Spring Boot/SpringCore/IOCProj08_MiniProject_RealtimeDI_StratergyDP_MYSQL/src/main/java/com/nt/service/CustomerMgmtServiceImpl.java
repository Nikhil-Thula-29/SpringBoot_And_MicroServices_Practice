package com.nt.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nt.dao.ICustomerDAO;
import com.nt.model.Customer;


@Service("custService")
public class CustomerMgmtServiceImpl implements ICustomerMgmtService{

	@Autowired
	private ICustomerDAO custDao;
	
	
	
	@Override
	public String registerCustomer(Customer cust) throws Exception {
		double disamount=(cust.getBillAmount()*(cust.getDiscount()/100));
		double finalamount=cust.getBillAmount()-disamount;
		cust.setFinalAmount(finalamount);
		int count=custDao.insert(cust);
		return count==0?"Customer registration failed":"Customer Registered having BillAmount::"+cust.getBillAmount()+" Discount Amount of "+disamount+ " Final amount of "+finalamount;
	}

}
