package com.nt.rest;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/message-api")
public class WishMessageRenderingController {

	@GetMapping("/wish")
	public ResponseEntity<String> showMessage(){
		//get System date and time
		LocalDateTime ldt=LocalDateTime.now();
		//get current hour the day
		int hour=ldt.getHour();	//24 hours format
		String msg=null;
		if(hour<12) {
			msg="Good Morning...";
		}else if(hour<16) {
			msg="Good Afternoon..";
		}else if(hour<20) {
			msg="Good Evening";
		}else {
			msg="Good Night";
		}
		
		return new ResponseEntity<String>(msg,HttpStatus.OK);
	}
}
