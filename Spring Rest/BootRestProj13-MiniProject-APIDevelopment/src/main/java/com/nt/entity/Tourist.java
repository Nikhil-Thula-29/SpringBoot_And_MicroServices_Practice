package com.nt.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

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
import lombok.NonNull;

@Entity
@Table(name="REST_TOURIST")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tourist implements Serializable{

	@Id
	@SequenceGenerator(name="gen1",sequenceName="TID_SEQ",initialValue = 1,allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private Integer tid;
	@Column(length=20)
	@NonNull
	private String tname;
	
	@Column(length=20)
	@NonNull
	private String taddrs;
	
	@Column(length=20)
	@NonNull
	private String packageType;
	@NonNull
	private Double budget;
	@NonNull
	private LocalDateTime startDate;
	@NonNull
	private LocalDateTime endDate;
}
