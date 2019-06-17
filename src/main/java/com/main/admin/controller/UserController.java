package com.main.admin.controller;

import java.security.Principal;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.admin.entity.User;
import com.main.admin.model.CustomUserDetails;
import com.main.admin.service.UserService;


@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@PostMapping(value = "/login")
	public String login() {
		return "login";
	}
	
	@GetMapping("/admin/index")
	public String index(ModelMap modelMap,Principal principal) {
		CustomUserDetails loginedUser = (CustomUserDetails) ((Authentication) principal).getPrincipal();
		modelMap.put("userName", loginedUser.getUser().getTenDangNhap());
		modelMap.put("userId", loginedUser.getUser().getId());
		modelMap.put("id_nx", loginedUser.getUser().getNhaXe().getId_nx());
		return "/admin/index";
	}
	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}
	@GetMapping("/admin/user/listUser")
	public String listUsers() {
		return "/admin/user/listUser";
	}
	@GetMapping("/admin/user/listUsers")
	public @ResponseBody List<User> getlistUsers() {
		return userService.findAll();
	}
}
