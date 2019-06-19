package com.main.admin.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.admin.entity.NhaXe;
import com.main.admin.model.CustomUserDetails;
import com.main.admin.service.NhaXeService;


@Controller
public class CoachController {
	@Autowired
	private NhaXeService nhaXeService;
	
	@GetMapping("/admin/user/listCoachs")
	public String index(ModelMap modelMap,Principal principal) {
		CustomUserDetails loginedUser = (CustomUserDetails) ((Authentication) principal).getPrincipal();
		modelMap.put("tenNhaXe", loginedUser.getUser().getNhaXe().getTenNhaXe());
		return "/admin/user/listCoach";
	}
	@GetMapping("/admin/user/listCoach")
	public @ResponseBody List<NhaXe> getlistNhaXe(){
		return nhaXeService.findAll();
	}
	@GetMapping("/admin/user/addCoach")
	public String addCoach(ModelMap modelMap) {
		return "/admin/user/addCoach";
	}
	
}
