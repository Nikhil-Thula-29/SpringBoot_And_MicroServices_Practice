package com.nt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.nt.entity.Customer;

@Repository
public interface ICustomerRepository extends JpaRepository<Customer, Integer>{

}
