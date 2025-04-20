package com.nt.service;

import java.util.List;

import com.nt.entity.Customer;

public interface ICustomerManagementService {

	public String registerCustomer(Customer cust);
	public String registerCustomerGroup(Iterable<Customer> list);
	public boolean isCustomerAvailable(Integer id);
	public long getCustomerCount();
	public Iterable<Customer> getAllCustomers();
	public Iterable<Customer> getCustomersByIds(Iterable<Integer> ids);
	public String showCustomerById(int id);
	public Customer findCustomerById(int id);
	public Customer fetchCustomerById(int id);
	public String adjustCustomerBillAmount(int id,float discountPercentage);
	public String registerOrUpdateCustomerDetails(Customer customer);
	public String removeCustomerById(int id);
	public String deleteCustomer(Customer cust);
	public String deleteAllCustomers();
	public String removeAllCustomersByIds(List<Integer> ids);
}
