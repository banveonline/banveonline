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

import com.main.admin.entity.NhaXe;
import com.main.admin.form.CoachForm;
import com.main.admin.form.JsonRespone;
import com.main.admin.model.CustomUserDetails;
import com.main.admin.service.NhaXeService;


@Controller
public class CoachController {
	@Autowired
	private NhaXeService nhaXeService;
	
	@GetMapping("/admin/user/listCoachs")
	public String index(ModelMap modelMap,Principal principal) {
		checkLogin(modelMap, principal);
		return "/admin/user/listCoach";
	}
	@GetMapping("/admin/user/listCoach")
	public @ResponseBody List<NhaXe> getlistNhaXe(){
		return nhaXeService.findAll();
	}
	@GetMapping("/admin/user/addCoachs")
	public String addCoach(ModelMap modelMap, Principal principal) {
		checkLogin(modelMap, principal);
		CoachForm coachForm = new CoachForm();
		modelMap.put("coachForm", coachForm);
		return "/admin/user/addCoach";
	}
	@PostMapping("/admin/user/addCoach")
	public @ResponseBody JsonRespone saveUser(ModelMap modelMap, @ModelAttribute("userForm") CoachForm coachForm) {
		boolean flg =  nhaXeService.addNhaXe(coachForm);
		JsonRespone jsonRespone = new JsonRespone();
		System.out.println(flg);
		if(flg) {
			jsonRespone.setValidated(true);
			return jsonRespone;
		}
		jsonRespone.setValidated(false);
		return jsonRespone;
	}
	@GetMapping("/user/coachName/{coachName}")
	public @ResponseBody JsonRespone checkNhaXe(ModelMap modelMap, @PathVariable String nhaXe) {
		System.out.println(nhaXe);
		boolean flg = nhaXeService.checkNhaXe(nhaXe);
		JsonRespone jsonRespone = new JsonRespone();
		if(flg) {
			jsonRespone.setValidated(true);
			return jsonRespone;
		}
		jsonRespone.setValidated(false);
		System.out.println("-----" + jsonRespone.toString());
		return jsonRespone;
	}
	@DeleteMapping("/admin/user/deleteCoach/{id}")
	public @ResponseBody JsonRespone  delete(ModelMap modelMap, @PathVariable("id") int id) {
		JsonRespone jsonRespone = new JsonRespone();
		boolean flg = nhaXeService.xoaNhaXe(id);
		if( flg) {
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
