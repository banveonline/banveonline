package com.main.admin.controller;

import java.security.Principal;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.admin.entity.ChuyenXe;
import com.main.admin.model.CustomUserDetails;
import com.main.admin.service.ChuyenXeService;
import com.main.admin.service.NhaXeService;
import com.main.admin.service.ThanhPhoService;

@Controller
public class QuanLyChuyenXeController {

	@Autowired
	private ChuyenXeService chuyenXeService;
	@Autowired
	private ThanhPhoService thanhPhoService;
	@Autowired
	private NhaXeService nhaXeService;

	@GetMapping("/admin/chuyenxe/danhsach")
	public String index(ModelMap modelMap, Principal principal) {
		CustomUserDetails loginedUser = checkLogin(modelMap, principal);
		modelMap.put("chuyenxe", chuyenXeService.listChuyenXe(loginedUser.getUser().getId_nx()));
		return "admin/listTrip";
	}

	@GetMapping("/admin/chuyenxe/taomoi")
	public String taoChuyenXe(ModelMap modelMap, Principal principal) {
		checkLogin(modelMap, principal);
		modelMap.put("chuyenxe", new ChuyenXe());
		modelMap.put("thanhpho", thanhPhoService.findAll());
		return "admin/insertTrip";
	}

	@PostMapping("/admin/chuyenxe/luu")
	public String luu(@Valid ChuyenXe chuyenXe, BindingResult result, RedirectAttributes redirect, ModelMap modelMap,
			Principal principal) {
		if (result.hasErrors()) {
			System.out.println(result);
			redirect.addFlashAttribute("success", "Lưu chuyến xe thất bại!");
			return "redirect:/admin/chuyenxe/danhsach";
		}
		CustomUserDetails loginedUser = (CustomUserDetails) ((Authentication) principal).getPrincipal();
		chuyenXe.setNhaXe(nhaXeService.timNhaXe(loginedUser.getUser().getId_nx()));
		chuyenXeService.luuChuyenXe(chuyenXe);
		redirect.addFlashAttribute("success", "Lưu chuyến xe thành công!");
		return "redirect:/admin/chuyenxe/danhsach";
	}

	@GetMapping("/admin/chuyenxe/{id}/sua")
	public String sua(@PathVariable int id, ModelMap modelMap, RedirectAttributes redirect, Principal principal) {
		checkLogin(modelMap, principal);
		modelMap.addAttribute("chuyenxe", chuyenXeService.tim(id));
		modelMap.put("thanhpho", thanhPhoService.findAll());
		redirect.addFlashAttribute("success", "Sửa chuyến xe thành công!");
		return "admin/editTrip";
	}

	@GetMapping("/admin/chuyenxe/{id}/xoa")
	public String xoa(@PathVariable int id, RedirectAttributes redirect) {
		chuyenXeService.xoaChuyenXe(id);
		redirect.addFlashAttribute("success", "Xóa chuyến xe thành công!");
		return "redirect:/admin/chuyenxe/danhsach";
	}

	public CustomUserDetails checkLogin(ModelMap modelMap, Principal principal) {
		CustomUserDetails loginedUser = (CustomUserDetails) ((Authentication) principal).getPrincipal();
		modelMap.put("userName", loginedUser.getUser().getTenDangNhap());
		modelMap.put("userId", loginedUser.getUser().getId());
		modelMap.put("id_nx", loginedUser.getUser().getId_nx());
		return loginedUser;
	}
}
