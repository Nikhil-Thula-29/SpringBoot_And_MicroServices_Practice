package com.nt.model;

import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Data;

//Model cum Enity clas


@Entity
@Data
@Table(name="BOOT_EMP")
@SQLDelete(sql="UPDATE BOOT_EMP SET STATUS='deleted' WHERE EMPNO=?")//for soft deletion
@Where(clause="STATUS <> 'deleted'")//to avoid softely deleted recoreds not participation in any persistance operations
public class Employee {

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "EMP_ID_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Integer empno;
	private String ename;
	private String job="CLERK";
	private Double sal;
	private Integer deptno;
	private String status="active";
}
