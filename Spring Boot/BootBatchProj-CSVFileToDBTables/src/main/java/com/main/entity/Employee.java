package com.main.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Table(name="EMPLOYEE_INFO_BATCH")
@Data
public class Employee {

	@Id
	private Integer empno;
	private String ename;
	private String eadd;
	private Double salary;
	private Double grosssal;
	private Double netsal;
}
