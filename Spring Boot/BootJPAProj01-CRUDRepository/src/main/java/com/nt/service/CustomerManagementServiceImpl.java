package com.nt.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepository;



@Service("custservice")
public class CustomerManagementServiceImpl implements ICustomerManagementService {

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public String registerCustomer(Customer cust) {
		
		System.out.println("Repo's InMemory Proxy class name:: "+repo.getClass());
		System.out.println("Repo's InMemory proxy class implemented interfaces:: "+Arrays.toString(repo.getClass().getInterfaces()));
		System.out.println("Repo's InMemory proxy class implemented methods:: "+Arrays.toString(repo.getClass().getMethods()));
		
		Customer custom=repo.save(cust);	//saveAll is there for saving multiple objects
		System.out.println("custom obj data:: "+custom);
		return "Customer obj is saved(record inserted) having the id value:"+custom.getCno();
	}

	@Override
	public String registerCustomerGroup(Iterable<Customer> list) {
		if(list!=null) {
		Iterable<Customer> it=repo.saveAll(list);
		int size=((Collection)it).size();	//Iterable is not having size so type casting to collections
		List<Integer> custids=new ArrayList();
		it.forEach(val->{
			custids.add(val.getCno());
		});
		return size+" no.of customers are registered having the id values:: "+custids.toString();
		}else {
			throw new IllegalArgumentException("Invalid Inputs");
		}
	}

	@Override
	public boolean isCustomerAvailable(Integer id) {
		boolean flag=repo.existsById(id);
		return flag;
	}

	@Override
	public long getCustomerCount() {
		long count=repo.count();
		return count;
	}

	@Override
	public Iterable<Customer> getAllCustomers() {
		Iterable<Customer> it=repo.findAll();
		return it;
	}

	@Override
	public Iterable<Customer> getCustomersByIds(Iterable<Integer> ids) {
		Iterable<Customer> it=repo.findAllById(ids);
		return it;
	}

	@Override
	public String showCustomerById(int id) {
		Optional<Customer> opt=repo.findById(id);
		if(opt.isPresent()) {
			return id+" customer details are:: "+opt.get();
		}else {
			return "Customer not found";
		}
	}

	@Override
	public Customer findCustomerById(int id) {
		Optional<Customer> opt=repo.findById(id);
		if(opt.isPresent()) {
			return opt.get();
		}
		else {
			throw new IllegalArgumentException("Customer not found");
		}
	}

	@Override
	public Customer fetchCustomerById(int id) {
		return repo.findById(id).orElse(new Customer(00,"xxx","zzz",00.00f));
	}

	@Override
	public String adjustCustomerBillAmount(int id, float discountPercentage) {
		Optional<Customer> opt=repo.findById(id);
		if(opt.isPresent()) {
			Customer cust=opt.get();
			//calculate bill amount
			float discount=cust.getBillamt()*(discountPercentage/100.0f);
			//set final amount to customer
			cust.setBillamt(cust.getBillamt()-discount);
			repo.save(cust);
			return id+" customer details are updated";
		}else {
			return id+" customer are not found";
		}
		
	}


	//giving error
	
	@Override
	@Transactional
	public String registerOrUpdateCustomerDetails(Customer customer) {
		//get Customer details based on the given id
		Optional<Customer> opt=repo.findById(customer.getCno());
		if(opt.isPresent()) {
			repo.save(customer);
			return customer.getCno()+" id details are updated.";
		}else {
			int idval=repo.save(customer).getCno();
			return "Customer details are inserted with the id value "+idval;
		}
	}

	@Override
	public String removeCustomerById(int id) {
		Optional<Customer> opt=repo.findById(id);
		if(opt.isPresent()) {
			repo.deleteById(id);
			return id+" customer is found and deleted";
		}else {
			return id+" customer is not found for deletion";
		}
		
	}

	@Override
	public String deleteCustomer(Customer cust) {
		Optional<Customer> opt=repo.findById(cust.getCno());
		if(opt.isPresent()) {
			repo.delete(cust);
			return cust.getCno()+" customer is found and deleted";
		}else {
			return cust.getCno()+" customer is not found for deletion";
		}
	}

	@Override
	@Transactional
	public String deleteAllCustomers() {
		long count=repo.count();
		if(count>0) {
			repo.deleteAll();
			return count+" no.of total records are found and deleted.";
		}else {
			return "No Records are found and deleted.";
		}
		
	}

	@Override
	public String removeAllCustomersByIds(List<Integer> ids) {
		List<Customer> list=(List<Customer>) repo.findAllById(ids);
		if(ids.size()==list.size()) {
			repo.deleteAllById(ids);
			return ids.size()+" no.of records are deleted.";
		}else {
			return "given ids based records are not found for deletion.";
		}
		
		//or 
		//deletes all available ids 
		/*repo.deleteAllById(ids);
		return ids.size()+" no of records are deleted.";*/
	}

}
