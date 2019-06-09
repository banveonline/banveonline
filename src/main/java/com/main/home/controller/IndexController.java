package com.main.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.main.admin.service.ThanhPhoService;

@Controller
public class IndexController {
	
	@Autowired
	private ThanhPhoService thanhPhoService;
	
	@GetMapping(value = "/")
	public String home(Model model) {
		model.addAttribute("thanhpho", thanhPhoService.findAll());
		return "home/index";
	}
	

}
