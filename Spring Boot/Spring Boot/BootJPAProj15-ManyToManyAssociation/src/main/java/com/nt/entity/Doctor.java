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
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@Setter
@Table(name="JPA_MTM_DOCTOR")
@RequiredArgsConstructor
public class Doctor implements Serializable{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer did;
	@Column(length=20)
	@NonNull
	private String dname;
	@Column(length=20)
	@NonNull
	private String specilization;
	
	
	//many to many
	@ManyToMany(targetEntity = Patient.class,cascade = CascadeType.ALL,fetch = FetchType.LAZY)
	@JoinTable(name="DOCTORS_PATIENTS",joinColumns=@JoinColumn(name="doctor_id",referencedColumnName = "did"),
				inverseJoinColumns = @JoinColumn(name="patient_id",referencedColumnName = "pid"))
	private List<Patient> patients;	//many to many so collections=set
	
	public Doctor() {
		System.out.println("0-param Doctor");
	}

	@Override
	public String toString() {
		return "Doctor [did=" + did + ", dname=" + dname + ", specilization=" + specilization + "]";
	}
	
	
}
