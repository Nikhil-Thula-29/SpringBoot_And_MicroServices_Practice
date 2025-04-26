package com.nt.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nt.service.IFindSeasonService;

@Controller
public class SeasonOperationsController {
	
	@Autowired
	private IFindSeasonService serv;

	@RequestMapping("/")
	public String showHome() {
		return "welcome";
	}
	
	@RequestMapping("/season")
	public String showSeason(Map<String,Object> map) {
		//use service
		String msg=serv.findSeason();
		//keep the result in model attribute
		map.put("resultMsg", msg);
		//return lvn
		return "display";
	}
}
