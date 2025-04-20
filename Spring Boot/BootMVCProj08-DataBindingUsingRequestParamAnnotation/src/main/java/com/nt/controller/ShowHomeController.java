package com.nt.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShowHomeController {

	
	/*@GetMapping("/data")
	public String bindData(@RequestParam(value="sno",required=false) int no,
							@RequestParam(value="sname",required=false) String name) {
		System.out.println(no+"......"+name);
		return "show_result";
	}*/
	
	//or
	
	/*@GetMapping("/data")
	public String bindData(@RequestParam(required=false) int sno,
							@RequestParam(required=false) String sname) {	//here ?sno=101&sname=ajay matches so need of again.
		System.out.println(sno+"......"+sname);
		return "show_result";
	}*/
	
	/*@GetMapping("/data")
	public String bindData(@RequestParam(defaultValue = "200") int sno,
							@RequestParam(defaultValue = "suresh") String sname) {	//here ?sno=101&sname=ajay matches so need of again.
		System.out.println(sno+"......"+sname);
		return "show_result";
	}*/
	
	/*@GetMapping("/data")
	public String bindData(@RequestParam int sno,@RequestParam String sname,
							@RequestParam(name="sadd") String[] saddArray,
							@RequestParam(name="sadd") List<String> saddList,
							@RequestParam(name="sadd") Set saddSet) {
		
		System.out.println(sno+"......"+sname+"...."+Arrays.toString(saddArray)+"...."+saddList+"...."+saddSet);
		return "show_result";
	}*/
	
	
	@GetMapping("/data")
	public String bindData(@RequestParam int sno,@RequestParam String sname,
							@RequestParam(name="sadd") String saddrs) {	//give multiple it gives comma separeted values
		
		System.out.println(sno+"......"+sname+"...."+saddrs);
		return "show_result";
	}
}
