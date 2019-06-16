package com.main.admin.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.main.admin.entity.ChuyenXe;
import com.main.admin.model.CustomUserDetails;
import com.main.admin.service.ChuyenXeService;
import com.main.admin.service.VeService;

@Controller
public class QuanLyVeController {

	@Autowired
	private VeService veService;
	@Autowired
	private ChuyenXeService chuyenXeService;

	@GetMapping("/admin/datve/danhsach")
	private String index(ModelMap modelMap,Principal principal) {
		CustomUserDetails loginedUser = checkLogin(modelMap, principal);
//		modelMap.put("ve", veService.danhSachVe());
		return "admin/listTicket";
	}

	@GetMapping("/admin/datve/chi-tiet-dat-ve/{id}")
	public String ticketDetail(@PathVariable int id, ModelMap modelMap) {
		modelMap.put("ve", veService.tim(id));
		modelMap.put("chuyenxe", getChuyenXe( veService.tim(id).getChuyenxe().getId_CX()));
		return "admin/ticketDetail";
	}
	
	@GetMapping("/test")
	public String xxx() {
		return "home/test";
	}
	public ChuyenXe getChuyenXe(int id) {
		ChuyenXe chuyenXe = new ChuyenXe();
		Iterable<ChuyenXe> ls = chuyenXeService.listChuyenXe(id);
		for (ChuyenXe cx : ls) {
			if (cx.getId_CX() == id) {
				chuyenXe = cx;
				break;
			}else {
				System.out.println("Lôi");
			}
		}
		return chuyenXe;
	}
	public CustomUserDetails checkLogin(ModelMap modelMap, Principal principal) {
		CustomUserDetails loginedUser = (CustomUserDetails) ((Authentication) principal).getPrincipal();
		modelMap.put("userName", loginedUser.getUser().getTenDangNhap());
		modelMap.put("userId", loginedUser.getUser().getId());
		modelMap.put("id_nx", loginedUser.getUser().getId_nx());
		return loginedUser;
	}
}