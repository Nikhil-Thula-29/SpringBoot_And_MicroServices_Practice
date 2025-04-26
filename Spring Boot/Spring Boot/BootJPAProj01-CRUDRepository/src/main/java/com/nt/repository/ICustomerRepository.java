package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Customer;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer>{

}
