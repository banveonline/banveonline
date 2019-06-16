package com.main.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class NhaXeController {

	
	@GetMapping(value = "/nhaxe/{nha_xe}")
	public String index(@PathVariable String nha_xe,ModelMap modelMap ) {
		
		return "home/garage";
	}

}
