package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee-api")
public class EmployeeOperationsController {

	
	
	@GetMapping("/report/{eno}/{ename}")
	public ResponseEntity<String> showReport(@PathVariable("eno") int no,
	
			@PathVariable String ename) { // required=false-->wont work for pathvariable
		System.out.println(no + "......." + ename);
		return new ResponseEntity<String>(no + "......." + ename, HttpStatus.OK);
	}
	 
	 
	
	
	/*@GetMapping("/report/{eno}/{ename}")
	public ResponseEntity<String> showReport1(@PathVariable("eno") int no,
												@PathVariable String ename) { //required=false-->wont work for pathvariable
		return new ResponseEntity<String>("from showReprot1", HttpStatus.OK);
	}
	
	@GetMapping("/report/eno/ename") 
	public ResponseEntity<String> showReport2(){//required=false-->wont work for pathvariable 
		return new ResponseEntity<String>("from showReprot2",HttpStatus.OK); 
	}
	
	@GetMapping("/report/{eno}/ename") 
	public ResponseEntity<String> showReport3(@PathVariable("eno") int no){ //required=false-->wont work for pathvariable 
		return new ResponseEntity<String>("from showReprot3",HttpStatus.OK); 
	}
	
	@GetMapping("/report/eno/{ename}") 
	public ResponseEntity<String> showReport4(@PathVariable String ename){ //required=false-->wont work forpathvariable 
		return new ResponseEntity<String>("from showReprot4",HttpStatus.OK); 
	}*/
	 
	
	
	
	/*@GetMapping(value={"/report/{eno}/{ename}","/report/{eno}","/report/{ename}"}) 
	public ResponseEntity<String> showReport(@PathVariable(name="eno",required=false) String no,
												@PathVariable(required=false) String ename) { // required=false-->work only when value=/report/{ename},/report if both are same type
		System.out.println(no + "......." + ename); 
		return new ResponseEntity<String>(no + "......." + ename, HttpStatus.OK); 
	}*/
	 
}
