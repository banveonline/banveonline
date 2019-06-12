package com.main.home.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.main.admin.DAO.ChuyenXeDAO;

@Controller
public class ChuyenXeController {

	@Autowired
	private ChuyenXeDAO chuyenXeDAO;

	@GetMapping(value = "/chuyenxe2/{comment}")
	public String index(@PathVariable String comment, ModelMap modelMap) {
		if(comment.equals("all")) {
			modelMap.put("chuyenxe", chuyenXeDAO.findAll());
		}else if(comment.equals("hcm-hn")) {
			modelMap.put("chuyenxe", chuyenXeDAO.timChuyenXeCungTuyen("Hồ Chí Minh", "Hà Nội"));
		}
		return "home/garage";
	}
}
