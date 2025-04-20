package com.nt.entity;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_CUSTOMER_TAB")		//If not provided "customer" will be table name i.e class name with first letter as lower
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor	//where ever nonull is there it create paramterized constructor
public class Customer {		
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)	//generates value to the cno property automatically starting with (1,2,52,102,+50..)
	@SequenceGenerator(name="gen1",sequenceName = "CNO_SEQ",initialValue = 1,allocationSize = 1)	//this is only for oracle db
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "gen1")	//only for oracle db
	
	private Integer cno;
	@Column(name="CNAME",length=20)	//optional if cname and cname equal
	@Nonnull
	private String cname;
	@Column(name="CADDRS",length=20)  //optional
	@Nonnull
	//@Transient	//by this caddrs wont add in the db table
	private String caddrs;
	@Column(name="BILLAMT")
	@Nonnull
	private Float billamt;

}
