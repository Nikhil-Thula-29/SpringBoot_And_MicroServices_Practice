package com.nt.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.nt.model.Department;

public interface IDepartmentRepository extends JpaRepository<Department, Integer>{

	@Query("select deptno from Department")	//department not table name entity name rem(so consider case sensitive) bcz it is enity not tables only java class
	public List<Integer> fetchAllDepartmentNos();
}