package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	//order no need to match and name=name and addrs=addrs should match any thing can take
	@Query(value="INSERT INTO JPA_CUSTOMER_TAB VALUES(CNO_SEQ.NEXTVAL,:billamt,:name,:addrs)",nativeQuery=true)
	@Modifying
	@Transactional
	public int insertCustomer(String name,String addrs,double billamt);
}
