package com.main.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.main.admin.service.VeService;

@Controller
public class QuanLyVeController {
	
	@Autowired
	private VeService veService;
	
	@GetMapping("/admin/datve/danhsach")
	private String index(ModelMap modelMap) {
		modelMap.put("ve", veService.danhSachVe());
		return "admin/listTicket";
	}
}
