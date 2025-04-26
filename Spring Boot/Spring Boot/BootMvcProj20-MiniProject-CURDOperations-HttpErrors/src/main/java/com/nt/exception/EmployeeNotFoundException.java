package com.nt.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code=HttpStatus.BAD_GATEWAY)	//setting our http request number here it is 502
public class EmployeeNotFoundException extends Exception {

	public EmployeeNotFoundException(String message) {
		super(message);
	}
	
	public EmployeeNotFoundException() {
		super();
	}
}
