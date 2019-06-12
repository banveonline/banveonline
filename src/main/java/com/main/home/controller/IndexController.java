package com.main.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.main.admin.entity.ChuyenXe;
import com.main.admin.service.ChuyenXeService;
import com.main.admin.service.ThanhPhoService;

@Controller
public class IndexController {
	
	@Autowired
	private ThanhPhoService thanhPhoService;
	@Autowired
	private ChuyenXeService chuyenXeService;
	
	@GetMapping(value = "/")
	public String home(ModelMap modelMap) {
		modelMap.put("thanhpho", thanhPhoService.findAll());
		modelMap.put("saigon_hanoi", chuyenXeService.chuyenXeCungTuyen("Hồ Chí Minh","Hà Nội"));
		Iterable<ChuyenXe> ls = chuyenXeService.chuyenXeCungTuyen("Hồ Chí Minh","Hà Nội");
		for(ChuyenXe c : ls) {
			System.out.println(c.getGaDen());
		}
		return "home/index";
	}
	

}
