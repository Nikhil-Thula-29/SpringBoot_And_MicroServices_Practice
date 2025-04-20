package com.nt.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.annotation.Nonnull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.persistence.Version;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name="BANK_ACCOUNT_TAB")
@NoArgsConstructor
@RequiredArgsConstructor
public class BankAccount {

	@Id
	@Column(name="ACCNO")
	@SequenceGenerator(name="gen1",sequenceName = "ACCNO_SEQ",initialValue = 10000000,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE,generator = "gen1")
	private Long accno;
	@Column(length=20)
	@Nonnull
	private String holderName;
	@Nonnull
	private Double balance;
	@Nonnull
	private Long mobileNo;
	
	
	@Version
	private Integer updateCount;	//update_count as col name to cap C i.e when we use camel case
	
	@CreationTimestamp
	private LocalDateTime creationTime;

	@UpdateTimestamp
	private LocalDateTime lastUpdationTime;
	
}
