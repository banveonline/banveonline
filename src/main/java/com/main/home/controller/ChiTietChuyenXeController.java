package com.main.home.controller;

import java.util.Date;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.main.admin.entity.ChuyenXe;
import com.main.admin.entity.Ve;
import com.main.admin.model.VeDetail;
import com.main.admin.service.ChuyenXeService;
import com.main.admin.service.VeService;

@Controller
public class ChiTietChuyenXeController {

	@Autowired
	private ChuyenXeService chuyenXeService;
	@Autowired
	private VeService veService;
	
	@GetMapping(value = "/{id}/detail")
	public String detail(ModelMap modelMap,@PathVariable int id) {
		ChuyenXe chuyenXe = chuyenXeService.tim(id);
		modelMap.put("chuyenXe", chuyenXe);
		VeDetail ve = new VeDetail();
		modelMap.put("ve", ve);
		modelMap.put("chuyenxecungtuyen", chuyenXeService.timChuyenXeTheoGaDi(chuyenXeService.tim(id).getGaDi()));
		return "home/detail";
	}
	@GetMapping("/notification")
	public String notification(){
		return "home/notification";
	}
	@PostMapping("/datve")
	public String datVe(@Valid VeDetail ve,BindingResult result,RedirectAttributes redirect) {
		if(result.hasErrors()) {
			redirect.addFlashAttribute("thongbao", "Đặt vé thất bại");
			return "redirect:/home/notification";
		}else {
			Date ngayDatVe = new Date();
			ve.setNgayDatVe(ngayDatVe);
			ChuyenXe chuyenXe = chuyenXeService.tim(ve.getId_CX());
			ve.setChuyenxe(chuyenXe);
			veService.luu(ve.convertToVe(ve,chuyenXe));
			redirect.addFlashAttribute("thongbao", "Đặt vé thành công");
			return "redirect:/notification";
		}
	}
}
