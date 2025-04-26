package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("show-controller")	//class level global path
public class ShowHomeController {

	@RequestMapping("/report")
	public String showReport() {
		System.out.println("ShowHomeController.showReport()");
		return "display";
	}
	
	
	@RequestMapping("/REPORT")
	public String showReport1() {
		System.out.println("ShowHomeController.showReport1()");
		return "display1";
	}
	
	
	@RequestMapping({"/report1","/report2","/report3"})
	//or
	//@RequestMapping(value={"/report1","/report2","/report3"})
	public String showReport2() {
		System.out.println("ShowHomeController.showReport2()");
		return "display";
	}
	
	
	@RequestMapping()	//=@RequestMapping("/")
	public String showHome() {
		System.out.println("ShowHomeController.showHome()");
		return "welcome";
	}
	
	
	//@RequestMapping(value="/getreport",method = RequestMethod.GET)
	//or
	@GetMapping("/getreport")
	public String showReport3() {
		System.out.println("ShowHomeController.showReport3()");
		return "display";
	};
	
	
	//@RequestMapping(value="/postreport",method=RequestMethod.POST)
	//or
	@PostMapping("/postreport")
	public String showReport4() {
		System.out.println("ShowHomeController.showReport4()");
		return "display1";
	}
	
	
	@GetMapping("/all")
	public String showReport5() {
		System.out.println("ShowHomeController.showReport4()");
		return "display";
	}
	
	
}
