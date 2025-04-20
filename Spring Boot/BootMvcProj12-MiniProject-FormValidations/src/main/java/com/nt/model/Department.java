package com.nt.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="DEPARTMENT_DATA")
public class Department {
	
	@Id
	@GeneratedValue
	private Integer deptno;
	private String dname;
	private String loc;

}
