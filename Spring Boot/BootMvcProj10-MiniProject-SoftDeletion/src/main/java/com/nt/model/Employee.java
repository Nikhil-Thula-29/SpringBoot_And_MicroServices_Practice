package com.nt.model;




import java.io.Serializable;

import org.hibernate.annotations.Filter;
import org.hibernate.annotations.FilterDef;
import org.hibernate.annotations.ParamDef;
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
@SQLDelete(sql="UPDATE BOOT_EMP SET STATUS='deleted' WHERE EMPNO=?")	//for soft deletion
@Where(clause="STATUS<>'deleted'")	//To avoid softley deleted records not participating in any persistance opertations(deprecated)

//To avoid softley deleted records not participating in any persistance opertations
/*@FilterDef(
	    name = "statusFilter",
	    parameters = @ParamDef(name = "excludedStatus", type = String.class)
	)
	@Filter(
	    name = "statusFilter",
	    condition = "STATUS <> :excludedStatus"
	)*/
public class Employee implements Serializable {

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
