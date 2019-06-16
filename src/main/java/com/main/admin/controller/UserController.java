package com.main.admin.controller;

import java.security.Principal;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.main.admin.model.CustomUserDetails;

@Controller
public class UserController {
	
	@PostMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/admin/index")
	public String index(ModelMap modelMap,Principal principal) {
		CustomUserDetails loginedUser = (CustomUserDetails) ((Authentication) principal).getPrincipal();
		modelMap.put("userName", loginedUser.getUser().getTenDangNhap());
		modelMap.put("userId", loginedUser.getUser().getId());
		modelMap.put("id_nx", loginedUser.getUser().getId_nx());
		return "/admin/index";
	}
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
}
