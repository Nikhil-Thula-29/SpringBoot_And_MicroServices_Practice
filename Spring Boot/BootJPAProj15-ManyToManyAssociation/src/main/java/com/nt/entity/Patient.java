package com.nt.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="JPA_MTM_PATIENT")
@RequiredArgsConstructor
public class Patient implements Serializable {
	
	public Patient() {
		System.out.println("0-Param Constructor Patient");
	}
	

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "pid_seq",initialValue = 1000,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer pid;
	@Column(length=20)
	@NonNull
	private String pname;
	@NonNull
	private Integer age;
	@Column(length=20)
	@NonNull
	private String problem;
	
	
	//many to many
	@ManyToMany(targetEntity = Doctor.class,cascade = CascadeType.ALL,fetch=FetchType.LAZY)
	@JoinTable(name="DOCTORS_PATIENTS",joinColumns=@JoinColumn(name="patient_id",referencedColumnName = "pid"),
			   inverseJoinColumns = @JoinColumn(name="doctor_id",referencedColumnName = "did"))
	private List<Doctor> doctors;				//many to many so collections=set


	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", problem=" + problem + "]";
	}
	

}
