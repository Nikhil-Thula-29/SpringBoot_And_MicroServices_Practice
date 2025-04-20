package com.nt.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepository;

@Service("custservice")
public class CustomerManagementService implements ICustomerManagementService {

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public Iterable<Customer> getAllCustomers(boolean ascOrder, String... properties) {
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,properties);
		Iterable<Customer> it=repo.findAll(sort);
		return it;
	}

	@Override
	public Page<Customer> getCustomerByPageNo(int pageNo, int pageSize) {
		Pageable pegable=PageRequest.of(pageNo, pageSize);
		Page page=repo.findAll(pegable);
		return page;
	}

	@Override
	public Page<Customer> getSortedCustomerPageNo(int pageNo, int pagesize, boolean ascOrder, String... properties) {
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,properties);
		Pageable pageable=PageRequest.of(pageNo, pagesize,sort);	//rem:: Inside Pegable we have to keep sort
		Page page=repo.findAll(pageable);
		return page;		
	}

	@Override
	public void showCustomersPageByPage(int pageSize) {
		//get total records count
		long count=repo.count();
		//get page count
		long pagecount=count/pageSize;
		pagecount=(count%pageSize==0?pagecount:++pagecount);	//rem here ++pagecount not +1;
		for(int i=0;i<pagecount;i++) {
			//prepare the pageable object
			Pageable pegable=PageRequest.of(i, pageSize);
			Page<Customer> page=repo.findAll(pegable);
			page.forEach(System.out::println);
			System.out.println("----------------"+(page.getNumber()+1)+"/"+page.getTotalPages()+"---------------");
		}
		
	}

}
