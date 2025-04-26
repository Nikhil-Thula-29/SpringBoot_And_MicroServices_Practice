package com.nt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test-controller")	//class level global path
public class TestController {

	@GetMapping("/all")
	public String testcont() {
		System.out.println("TestController.testcont()");
		return "display1";
	}
}
