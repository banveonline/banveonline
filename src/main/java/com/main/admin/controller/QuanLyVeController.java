package com.main.admin.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import com.main.admin.entity.ChuyenXe;
import com.main.admin.form.JsonRespone;
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
		modelMap.put("ve", veService.danhSachVe(loginedUser.getUser().getNhaXe().getId_nx()));
		return "admin/listTicket";
	}

	@GetMapping("/admin/datve/chi-tiet-dat-ve/{id}")
	public String ticketDetail(@PathVariable int id, ModelMap modelMap,Principal principal) {
		checkLogin(modelMap, principal);
		modelMap.put("ve", veService.tim(id));
		modelMap.put("chuyenxe", getChuyenXe( veService.tim(id).getChuyenxe().getId_CX()));
		return "admin/ticketDetail";
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
	@DeleteMapping("/admin/ticket/delete/{id}")
	public @ResponseBody JsonRespone deleteTicket(ModelMap modelMap,@PathVariable("id") int id,Principal principal) {
		checkLogin(modelMap, principal);
		JsonRespone jsonRespone = new JsonRespone();
		boolean ck = veService.xoa(id);
		System.out.println(ck);
		if(ck) {
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