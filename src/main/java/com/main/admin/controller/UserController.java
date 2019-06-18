package com.main.admin.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.admin.entity.User;
import com.main.admin.form.UserForm;
import com.main.admin.model.CustomUserDetails;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@PostMapping(value = "/login")
	public String login() {
		return "login";
	}

	@GetMapping("/admin/index")
	public String index(ModelMap modelMap, Principal principal) {
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

	@GetMapping("/admin/user/view/{id}")
	public String view(@PathVariable int id, ModelMap modelMap) {
		return "/admin/user/view";
	}

	@GetMapping("/admin/user/addUser")
	public String addUser(ModelMap modelMap) {
		UserForm userForm = new UserForm();
		modelMap.put("userForm", userForm);
		return "/admin/user/addUser";
	}
	
	@GetMapping("/user/userName/{userName}")
	public @ResponseBody boolean checkUserName(@PathVariable String userName) {
		return userService.checkUserName(userName);
	}
	
	@GetMapping("/user/email/{email}")
	public @ResponseBody boolean checkEmail(@PathVariable String email) {
		return userService.checkEmail(email);
	}
	@PostMapping("/admin/user/add")
	public @ResponseBody boolean saveUser(@ModelAttribute("userForm") UserForm userForm) {
		return userService.addUser(userForm);
	}
}
