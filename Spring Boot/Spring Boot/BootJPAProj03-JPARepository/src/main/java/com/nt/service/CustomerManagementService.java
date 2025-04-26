package com.nt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.nt.entity.Customer;
import com.nt.repository.ICustomerRepository;


@Service("custservice")
public class CustomerManagementService implements ICustomerManagementService{

	@Autowired
	private ICustomerRepository repo;
	
	@Override
	public String deleteCustomerByIds(List<Integer> ids) {
		List<Customer> list=repo.findAllById(ids);
		if(list.size()!=0) {
			repo.deleteAllByIdInBatch(ids);
			return list.size()+" no.of records are deleted.";
		}else {
			return "no records found for deletion.";
		}
	}

	@Override
	public Customer getCustomerById(int id) {
		//Customer cust=repo.getById(id);	//deprecated
		//Customer cust=repo.getOne(id);   //deprecated
		Customer cust=repo.getReferenceById(id);	//latest
		return cust;
	}

	@Override
	public List<Customer> showCustomerByExampleData(Customer cust, boolean ascOrder, String... properties) {
		//to hold obj and to pass where required we use Example
		//prepare Examle obj having customer obj
		Example<Customer> examp=Example.of(cust);
		Sort sort=Sort.by(ascOrder?Direction.ASC:Direction.DESC,properties);
		List<Customer> list=repo.findAll(examp,sort);
		return list;
	}

	@Override
	public String groupRegistrations(List<Customer> list) {
		repo.saveAllAndFlush(list);
		return list.size()+" no.of records are saved.";
	}

}
