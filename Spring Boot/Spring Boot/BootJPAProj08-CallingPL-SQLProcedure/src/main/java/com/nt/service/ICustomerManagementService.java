package com.nt.service;

import java.util.List;

import com.nt.entity.Customer;

public interface ICustomerManagementService {

	public List<Customer> getCustomerByBillAmountRange(double start,double end);
}
