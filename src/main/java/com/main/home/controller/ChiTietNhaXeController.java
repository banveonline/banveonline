package com.main.home.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ChiTietNhaXeController {

	@GetMapping(value = "/p")
	public String index(ModelMap modelMap) {
		return "home/nhaxe";
	}

}
