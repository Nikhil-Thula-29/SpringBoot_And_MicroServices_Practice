package com.nt.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.nt.model.Student;

@Controller
public class StudentOperationsController {

	@GetMapping("/")
	public String showHomePage() {
		return "welcome";
	}
	
	@GetMapping("/register")
	public String showStudentRegisterpage() {  //for form launching
		return "student_register_form";
	}
	
	
	@PostMapping("/register")
	public String processStudentRegForm(Map<String,Object> map,@ModelAttribute("stud")Student st) {	//for form submission
		System.out.println("model class obj data:: "+st);
		//keep model class obj as the model attribute
		map.put("studInfo", st);
		return "show_result";
	}
}
