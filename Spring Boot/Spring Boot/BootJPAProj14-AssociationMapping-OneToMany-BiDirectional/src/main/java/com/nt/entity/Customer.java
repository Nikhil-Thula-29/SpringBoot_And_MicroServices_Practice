package com.nt.entity;

import java.io.Serializable;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;



//BI-Directional due to @JoinColumn is using both sides to made changes
@Entity
@Table(name="JPA_OTM_CUSTOMER_TAB")		//OTM=ONE TO MANY
@Setter
@Getter
@EqualsAndHashCode
@RequiredArgsConstructor
public class Customer implements Serializable{

	public Customer() {
		System.out.println("Customer 0-param constructor");
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer cid;
	@Column(length=20)
	@NonNull
	private String cname;
	@Column(length=20)
	@NonNull
	private String caddrs;
	@OneToMany(targetEntity=PhoneNumber.class,cascade = CascadeType.ALL,orphanRemoval = true,mappedBy = "customer",fetch = FetchType.LAZY) //in one to many fetch is lazy by default
	//@JoinColumn(name="CUSTOMER_ID",referencedColumnName = "CID")	//we have to comment parent not child due to mappedby using in parent it will use customer to create fk
	private Set<PhoneNumber> phones;	//For one to many so collections like list,set

	
	//to String
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cname=" + cname + ", caddrs=" + caddrs + "]";
	}
	
}
