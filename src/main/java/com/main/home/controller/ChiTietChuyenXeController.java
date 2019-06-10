package com.main.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.main.admin.service.ChuyenXeService;

@Controller
public class ChiTietChuyenXeController {

	@Autowired
	private ChuyenXeService chuyenXeService;
	
	@GetMapping(value = "/{id}/detail")
	public String detail(ModelMap modelMap,@PathVariable int id) {
		modelMap.put("chiTietChuyenXe", chuyenXeService.tim(id));
		modelMap.put("chuyenxecungtuyen", chuyenXeService.timChuyenXeTheoGaDi(chuyenXeService.tim(id).getGaDi()));
		return "home/detail";
	}
}
