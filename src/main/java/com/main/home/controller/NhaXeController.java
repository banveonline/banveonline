package com.main.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.main.admin.DAO.NhaXeDAO;

@Controller
public class NhaXeController {

	@Autowired
	private NhaXeDAO nhaXeDAO;
	
	@GetMapping(value = "/chuyenxe/{comment}")
	public String index(@PathVariable String comment,ModelMap modelMap ) {
		
		return "home/garage";
	}

}
