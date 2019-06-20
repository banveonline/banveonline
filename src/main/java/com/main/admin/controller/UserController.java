package com.main.admin.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.admin.entity.User;
import com.main.admin.form.JsonRespone;
import com.main.admin.form.UserForm;
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
	public String index(ModelMap modelMap, Principal principal) {
		checkLogin(modelMap, principal);
		return "/admin/index";
	}

	@GetMapping("/logout")
	public String logout() {
		return "logout";
	}

	@GetMapping("/admin/user/listUser")
	public String listUsers(ModelMap modelMap, Principal principal) {
		checkLogin(modelMap, principal);
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
	public String addUser(ModelMap modelMap, Principal principal) {
		checkLogin(modelMap, principal);
		UserForm userForm = new UserForm();
		modelMap.put("userForm", userForm);
		return "/admin/user/addUser";
	}
	
	@GetMapping("/user/userName/{userName}")
	public @ResponseBody JsonRespone checkUserName(ModelMap modelMap, @PathVariable String userName) {
		boolean flg = userService.checkUserName(userName);
		JsonRespone jsonRespone = new JsonRespone();
		if(flg) {
			jsonRespone.setValidated(true);
			return jsonRespone;
		}
		jsonRespone.setValidated(false);
		System.out.println("-----" + jsonRespone.toString());
		return jsonRespone;
	}
	
	@GetMapping("/user/email/{email}")
	public @ResponseBody JsonRespone checkEmail(ModelMap modelMap, @PathVariable String email) {
		boolean flg = userService.checkEmail(email);
		JsonRespone jsonRespone = new JsonRespone();
		if(flg) {
			jsonRespone.setValidated(true);
			return jsonRespone;
		}
		jsonRespone.setValidated(false);
		return jsonRespone;
	}
	@PostMapping("/admin/user/add")
	public @ResponseBody JsonRespone saveUser(ModelMap modelMap, @ModelAttribute("userForm") UserForm userForm) {
		boolean flg =  userService.addUser(userForm);
		JsonRespone jsonRespone = new JsonRespone();
		if(flg) {
			jsonRespone.setValidated(true);
			return jsonRespone;
		}
		jsonRespone.setValidated(false);
		return jsonRespone;
	}
	
	@DeleteMapping("/admin/user/delete/{id}")
	public @ResponseBody JsonRespone  delete(ModelMap modelMap, @PathVariable("id") int id) {
		JsonRespone jsonRespone = new JsonRespone();
		boolean flg = userService.delete(id);
		if(flg) {
			jsonRespone.setValidated(true);
			return jsonRespone;
		}
		jsonRespone.setValidated(false);
		return jsonRespone;
	}
	public CustomUserDetails checkLogin(ModelMap modelMap, Principal principal) {
		CustomUserDetails loginedUser = (CustomUserDetails) ((Authentication) principal).getPrincipal();
		modelMap.put("userName", loginedUser.getUser().getTenDangNhap());
		modelMap.put("userId", loginedUser.getUser().getId());
		modelMap.put("tenNhaXe", loginedUser.getUser().getNhaXe().getTenNhaXe());
		modelMap.put("id_nx", loginedUser.getUser().getNhaXe().getId_nx());
		modelMap.put("loginedUser", loginedUser);
		return loginedUser;
	}
}
