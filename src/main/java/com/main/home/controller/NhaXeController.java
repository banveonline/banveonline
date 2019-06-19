package com.main.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.admin.entity.NhaXe;
import com.main.admin.service.NhaXeService;


@Controller
public class NhaXeController {

	@Autowired
	private NhaXeService nhaXeService;
	@GetMapping(value = "/nhaxe/{nha_xe}")
	public String index(@PathVariable(name = "nha_xe") String nhaXe,ModelMap modelMap ) {
		if(nhaXe.equals("tat-ca")) {
			modelMap.put("nhaxe", nhaXeService.findAll());
		}
		return "home/garage";
	}
	@GetMapping("/listNhaXe")
	public @ResponseBody List<NhaXe> listNhaXe(){
		return nhaXeService.findAll();
	}

}
