package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	//finder methods 
	//property name=cname-->Cname (c-capital i.e first letter)
	public List<Customer> findByCnameEquals(String name);
	//same
	public List<Customer> findByCnameIs(String name);
	//same
	public List<Customer> findByCname(String name);
	//can use get and read in 3.x in place of find
	public List<Customer> getByCname(String name);
	public List<Customer> readByCname(String name);
	public List<Customer> findByBillamtBetween(float startamt,float endamt);
	public List<Customer> findByCnameStartsWith(String inichar);
	public List<Customer> findByCnameEndsWith(String lastchar);
	public List<Customer> findByCnameContaining(String chars);
	public List<Customer> findByCnameContainingIgnoreCase(String chars);
	public List<Customer> findByCnameLikeIgnoreCase(String chars);
	
	//mixed conditions
	public List<Customer> findByBillamtGreaterThanEqualAndBillamtLessThanEqual(float startAmt,float endAmt);
	//In takes List<-> values because in means multiple
	public List<Customer> findByCaddrsInIgnoreCaseOrCnameContainingIgnoreCase(List<String> addresses,String nameChars);
	
 	
}
