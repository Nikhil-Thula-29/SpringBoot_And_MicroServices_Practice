package com.nt.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

	private Integer cno;
	private String cname;
	private String cadd;
	private Float billAmount;
	private LocalDateTime top;
	
}
