package com.main.admin.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.main.admin.entity.User;
import com.main.admin.service.UserService;
import com.main.filter.JwtService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private JwtService jwtService;

	
	@PostMapping(value = "/admin/dangNhap")
	public String dangNhap(@Valid User user,ModelMap modelMap,HttpServletResponse response) {
		User userSelected = userService.checkLogin(user.getTenDangNhap(),user.getMatKhau());
		if (userSelected != null) {
			String token = jwtService.generateTokenLogin(user.getTenDangNhap());
			modelMap.put("tenDangNhap", userSelected.getTenDangNhap());
			modelMap.put("token", token);
			Cookie cookie = new Cookie("Authorization", token);
			cookie.setMaxAge(24 * 60 * 60);
	        response.addCookie(cookie);
	        System.out.println(token);
			return "/admin/index";
		}
		return "/";
	}
	
	@GetMapping("/admin/index")
	public String index() {
		System.out.println("dit me may");
		return "/admin/index";
	}
}
