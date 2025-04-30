package com.nt.model;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class ErrorDetails {
	
	private LocalDateTime dateTime;
	private String msg;
	private String status;
	private Integer statusCode;

}
