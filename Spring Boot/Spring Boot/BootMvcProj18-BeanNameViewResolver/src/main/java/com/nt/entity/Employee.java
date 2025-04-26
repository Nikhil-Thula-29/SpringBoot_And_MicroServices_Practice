package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name="EMP")
public class Employee implements Serializable {

	@Id
	@GeneratedValue
	private Integer empno;
	private String ename;
	private String job;
	private Double sal;
	private Integer deptno;
	
}
