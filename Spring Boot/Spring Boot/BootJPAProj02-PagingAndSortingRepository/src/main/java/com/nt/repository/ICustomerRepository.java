package com.nt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Customer;

@Repository
public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Integer>,CrudRepository<Customer, Integer>{

}
