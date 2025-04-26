package com.nt.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="JPA_OTM_PHONENUMBER_TAB")
@Setter
@Getter
@RequiredArgsConstructor
public class PhoneNumber implements Serializable{
	
	
	
	public PhoneNumber() {
		System.out.println("PhoneNumber:: 0-param Constructor");
	}

	@Id
	@SequenceGenerator(name="gen1",sequenceName = "REGNO_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(generator = "gen1",strategy = GenerationType.SEQUENCE)
	private Integer regno;	
	@Column(nullable=false,unique=true)
	@NonNull
	private Long phoneNumber;
	@Column(length=20)
	@NonNull
	private String numberType;
	@Column(length=20)
	@NonNull
	private String provider;
	
	@ManyToOne(targetEntity = Customer.class,cascade = CascadeType.ALL)//fetch default is eager in many to one
	@JoinColumn(name="CUSTOMER_ID",referencedColumnName = "CID")	//Instead of writing both sided mappedBy="customer" in parent class will provie Bi-Directional assos only.
	private Customer customer;

	@Override
	public String toString() {
		return "PhoneNumber [regno=" + regno + ", phoneNumber=" + phoneNumber + ", numberType=" + numberType
				+ ", provider=" + provider + "]";
	}
	
	
	
}
