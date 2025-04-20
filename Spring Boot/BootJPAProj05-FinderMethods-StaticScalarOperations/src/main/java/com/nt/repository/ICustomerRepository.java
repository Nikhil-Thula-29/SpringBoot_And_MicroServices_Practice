package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Customer;
import com.nt.view.IResultView;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	//Scalar operations
	public List<IResultView> findByBillamtBetween(float startAmount,float endAmount);
	
	
}
