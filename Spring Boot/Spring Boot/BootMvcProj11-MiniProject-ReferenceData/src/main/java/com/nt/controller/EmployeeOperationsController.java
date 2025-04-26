package com.nt.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.nt.model.Employee;
import com.nt.service.IEmployeeManagementService;

import jakarta.servlet.http.HttpSession;

@Controller
public class EmployeeOperationsController {
	
	@Autowired
	private IEmployeeManagementService serv;

	@GetMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	
	@GetMapping("/report")
	public String fetchReports(Map<String,Object> map) {
		//use servie
		List<Employee> emplist=serv.fetchAllEmployees();
		//keeps the results in model attribute
		map.put("empInfo", emplist);
		return "show_report";
	}
	
	
	@GetMapping("/register")
	public String registerEmployee(@ModelAttribute("emp")Employee emp) {
		return "employee_register_form";
	}
	
	/*@PostMapping("/register")
	public String processRegisterEmployeeFormPage(Map<String,Object> map, 
												@ModelAttribute("emp") Employee emp) {
		String msg=serv.registerEmployee(emp);
		List<Employee> list=serv.fetchAllEmployees();	//this is for showing register list again in show_report
		//keep the results in model attribute
		map.put("resultMsg", msg);
		map.put("empInfo",list);	//this is for showing register list again in show_report
		return "show_report";
	}*/ 
	
	
	//best prg+redirectattributes
	@PostMapping("/register")	//used prg==post redirect get to avoid multiple insert when refersh is clicked in above post code
	public String processRegisterEmployeeFormPage(RedirectAttributes attr, //RedirectAttributes are used to pass resultmsg to get method as map is request scope
												@ModelAttribute("emp") Employee emp) {
		String msg=serv.registerEmployee(emp);
		//keep the results in model attribute
		attr.addFlashAttribute("resultMsg",msg);
		return "redirect:report";	//again redirecting to get not to insert multiple data(prg) and uses flash attributes instead of map
	}
	
	
	/*@PostMapping("/register")	//used prg==post redirect get to avoid multiple insert when refersh is clicked in above post code+here we have sessionattribute i.e with session for long time
	public String processRegisterEmployeeFormPage(HttpSession ses, //RedirectAttributes are used to pass resultmsg to get method as map is request scope
												@ModelAttribute("emp") Employee emp) {
		String msg=serv.registerEmployee(emp);
		//keep the results in model attribute
		ses.setAttribute("resultMsg",msg);
		return "redirect:report";	//again redirecting to get not to insert multiple data(prg) and uses flash attributes instead of map
	}*/
	
	
	@GetMapping("/edit")
	public String showEditFormPage(@RequestParam("no") int no,
									@ModelAttribute("emp") Employee emp) {
		Employee emp1=serv.getEmployeeByNo(no);
		//keep emp1 obj data to model class obj emp;
		BeanUtils.copyProperties(emp1, emp);
		return "employee_edit_form";
	}
	
	
	@PostMapping("/edit")
	public String processEditFormPage(RedirectAttributes attrs,
									@ModelAttribute("emp") Employee emp) {
		String msg=serv.updateEmployee(emp);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	
	@GetMapping("/delete")
	public String deleteEmployeeByNo(@RequestParam("no") int no,
									RedirectAttributes attrs) {
		String msg=serv.deleteEmployee(no);
		attrs.addFlashAttribute("resultMsg",msg);
		return "redirect:report";
	}
	
	
	
	//method of reference data holding the dept names
	@ModelAttribute("dnoList")	//called automatically while launching form page and dnoList match in jsp page in options tag
	public List<Integer> populateDeptNos(){
		//use service
		List<Integer> dnolis=serv.showAllDeptsNos();
		return dnolis;
	}
	
}
