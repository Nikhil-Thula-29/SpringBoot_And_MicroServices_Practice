package com.nt.service;

import org.springframework.data.domain.Page;

import com.nt.entity.Customer;

public interface ICustomerManagementService {

	public Iterable<Customer> getAllCustomers(boolean ascOrder,String... properties);
	public Page<Customer> getCustomerByPageNo(int pageNo,int pageSize);
	public Page<Customer> getSortedCustomerPageNo(int pageNo,int pagesize,boolean ascOrder,String... properties);
	public void showCustomersPageByPage(int pageSize);
}
