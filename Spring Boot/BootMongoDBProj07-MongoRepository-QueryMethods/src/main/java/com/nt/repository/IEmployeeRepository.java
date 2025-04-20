package com.nt.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.nt.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee,String >{

	//see notes about 1 and 0's
	@Query(fields="{ename:1,eaddrs:1,eno:1}",value="{eaddrs:?0}")	//1 is for selecting fields and 0 is for deselecting by default it will be 0 but only for id property.
	public List<Object[]> getEmpsDataByAddrs(String addrs);
	
	
//	/@Query(fields="{}",value= "{eaddrs:?0}")	//fields={} empty gives all cols
	@Query(value= "{eaddrs:?0}")	//fields={} empty gives all cols	
	//In mongo db ordinal param starts with 0 but in spring jpa it starts with 1 rem
	public List<Employee> getEmpsFullDataByAddrs(String addrs);
	
	@Query(value="{ename:?0,eaddrs:?1}")
	public List<Employee> getEmpsFulldataByNameAndAddrs(String name,String addrs);
	
	
	@Query(value="{$or:[{ename:?0,eaddrs:?1}]}")
	public List<Employee> getEmpsFullDataByNameOrAddrs(String name,String addrs);
	
	@Query(fields="{id=0,eno:1,ename:1,eaddrs:1,salary:1}",value="{salary:{$gte:?0},salary:{$lte:?1}}")
	public List<Object[]> getEmpsFullDataBySalary(double start,double end);
}