package com.nt.advice;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.nt.error.TouristNotFoundException;
import com.nt.model.ErrorDetails;

@RestControllerAdvice
public class TouristControllerAdvice {

	
	@ExceptionHandler(TouristNotFoundException.class)
	public ResponseEntity<ErrorDetails> handleTouristNotFoundException(TouristNotFoundException tnf){
		System.out.println("TouristControllerAdvice.handleTouristNotFoundException()");
		ErrorDetails edetails=new ErrorDetails(LocalDateTime.now(),tnf.getMessage(),"Resource not found",404);
		return new ResponseEntity<ErrorDetails>(edetails,HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorDetails> handleOtherException(Exception e){
		System.out.println("TouristControllerAdvice.handleOtherException()");
		ErrorDetails edetails=new ErrorDetails(LocalDateTime.now(),e.getMessage(),"Internal Server Error",500);
		return new ResponseEntity<ErrorDetails>(edetails,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
