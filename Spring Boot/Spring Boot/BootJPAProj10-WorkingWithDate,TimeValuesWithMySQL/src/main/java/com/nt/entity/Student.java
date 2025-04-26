package com.nt.entity;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@Table(name="JPA_STUDENT_TAB")		//If not provided "student" will be table name i.e class name with first letter as lower
@Data
@AllArgsConstructor
@NoArgsConstructor
@RequiredArgsConstructor	//where ever nonull is there it create paramterized constructor
public class Student {		
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)	//generates value to the cno property automatically starting with (1,2,52,102,+50..)
	@SequenceGenerator(name="gen1",sequenceName = "SNO_SEQ",initialValue = 1,allocationSize = 1)	//this is only for oracle db
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator = "gen1")	//only for oracle db
	private Integer sno;
	
	@Column(name="SNAME",length=20)	//optional if cname and cname equal
	@Nonnull
	private String sname;
	
	@Column(name="SADDRS",length=20)  //optional
	@Nonnull
	//@Transient	//by this caddrs wont add in the db table
	private String saddrs;
	
	private LocalDateTime dob;
	private LocalDate doa;	//date of admission
	private LocalTime toa;	//time of admission

}
