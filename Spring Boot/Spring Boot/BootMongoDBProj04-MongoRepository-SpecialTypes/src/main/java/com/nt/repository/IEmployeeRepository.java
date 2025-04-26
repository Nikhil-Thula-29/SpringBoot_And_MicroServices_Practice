package com.nt.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee,String >{

}
