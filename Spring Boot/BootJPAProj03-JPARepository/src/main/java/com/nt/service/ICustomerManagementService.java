package com.nt.service;

import java.util.List;

import org.springframework.data.domain.Example;

import com.nt.entity.Customer;

public interface ICustomerManagementService {

	public String deleteCustomerByIds(List<Integer> ids);
	public Customer getCustomerById(int id);
	public List<Customer> showCustomerByExampleData(Customer cust,boolean ascOrder,String... properties );//write vargs at the end
	public String groupRegistrations(List<Customer> list);
}
