package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.nt.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

	//Customer->entity name
	//@Query("from Customer")
	//or
	//@Query("from Customer cust")
	//or
	@Query("select cust from Customer as cust")
	public List<Customer> getAllCustomers();
	
	//@Query("from Customer where billamt between ?1 and ?2")
	//billamt->vairable name and :start and :end named params and @param required when method params and named parms wont match
	//@Query("from Customer where billamt between :start and :end")
	@Query("from Customer where billamt between :start and :end")
	public Iterable<Customer> getCustomersByBillamtRange(@Param("start") float startamt,@Param("end") float endamt);
	
	//cno,cname are variable names
	@Query("select cno,cname,billamt from Customer where cname in(:name1,:name2)") //scalar-projection(slecting specific multiple cols)
	public List<Object[]> getCustomerData(String name1,String name2);
	
	
	@Query("select caddrs from Customer where cname like :initChars")
	public List<String> findCustomerAddrsByNameChars(String initChars);  //scalar-projection(slecting specific single cols)
	
	
	@Query("from Customer where caddrs=:addrs")
	public Customer findCustomerDataByAddrs(String addrs);
	
	
	@Query("select cno,cname,billamt from Customer where caddrs=:addrs")
	public Object fetchCustomerDetailsByAddrs(String addrs);
	
	
	@Query("select cname from Customer where caddrs=:addrs")
	public Object fetchCustomerNameByAddrs(String addrs);
	
	
	@Query("select count(*) from Customer")
	public int fetchAllCustomerCount();
	
	@Query("select count(distinct caddrs) from Customer")
	public int getAllCustomerCount();
	
	@Query("select count(*),max(billamt),min(billamt),avg(billamt),sum(billamt) from Customer")
	public Object fetchCustomerAggregateData();
	
	
	@Query("update Customer set billamt=billamt+(billamt*:percentage/100.0f) where caddrs in(:city1,:city2)")
	@Transactional
	@Modifying
	public int updateCustomerBillAmountByAddress(double percentage,String city1,String city2);
	
	
	@Query("delete from Customer where billamt between :start and :end")
	@Transactional
	@Modifying
	public int deleteCustomersByBillAmtRange(double start,double end);
	
}
