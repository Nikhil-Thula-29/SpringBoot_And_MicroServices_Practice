package com.nt.controller;

import java.util.Date;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.support.BindingAwareModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ShowHomeController {

	/*@RequestMapping("/home")
	public String renderHome() {
		//return LVN
		return "welcome";
	}*/
	
	
	//we can use map and model and modelandview best is map
	//By map (best)
	/*@RequestMapping("/")
	public String renderHome(Map<String,Object> map) {
		System.out.println("map object class name:: "+map.getClass());
		//add model attributes
		map.put("att1", "val1");
		map.put("att2",new Date());
		//return LVN
		return "welcome";
	}*/
	
	
	
	//By Model
	/*@RequestMapping("/")
	public String renderHome(Model model) {
		System.out.println("model object class name:: "+model.getClass());
		//add model attributes
		model.addAttribute("att1", "val1");
		model.addAttribute("att2",new Date());
		//return LVN
		return "welcome";
	}*/
	
	
	//by modelmap
	/*@RequestMapping("/")
	public String renderHome(ModelMap map) {
		System.out.println("model object class name:: "+map.getClass());
		//add model attributes
		map.put("att1", "val1");
		map.put("att2",new Date());
		//return LVN
		return "welcome";
	}*/
	
	
	
	//here no LVN so pass is LVN so create pass.jsp file
	/*@RequestMapping("/pass")
	public Model renderHome() {
		Model model=new BindingAwareModelMap();
		model.addAttribute("att1","val1");
		model.addAttribute("att2", new Date());
		//return LVN
		return model;
	}*/
	
	
	
	/*@RequestMapping("/pass")
	public ModelAndView renderHome() {
		ModelAndView mav=new ModelAndView();
		mav.addObject("att1","val1");
		mav.addObject("att2", new Date());
		mav.setViewName("welcome");
		//return LVN
		return mav;
	}*/
	
	
	//using forward i.e with same scope and same request
	/*@RequestMapping("/pass")
	public String renderHome() {
		System.out.println("renderHome");
		return "forward:report";	//here report is not jsp page is request name
	}
	
	@RequestMapping("/report")	
	public String showReport() {
		System.out.println("showReport method");
		return "pass";
	}*/
	
	
	
	//using redirect i.e with different scope with new request
	@RequestMapping("/pass")
	public String renderHome() {
		System.out.println("renderHome");
		return "redirect:report";	//here report is not jsp page is request name
	}
	
	@RequestMapping("/report")	
	public String showReport() {
		System.out.println("showReport method");
		return "pass";
	}
}
