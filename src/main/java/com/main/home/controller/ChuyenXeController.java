package com.main.home.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.main.admin.service.ChuyenXeService;

@Controller
public class ChuyenXeController {

	@Autowired
	private ChuyenXeService chuyenXeService;

	@GetMapping("/chuyenxe/{comment}")
	public String index(@PathVariable String comment, ModelMap modelMap) {
		if (comment.equals("tat-ca-chuyen-xe")) {
			modelMap.put("chuyenxe", chuyenXeService.listChuyenXe());
		} else {
			modelMap.put("chuyenxe",
					chuyenXeService.chuyenXeCungTuyen(spitComment(comment).get(0), spitComment(comment).get(1)));
		}
		return "home/trips";
	}

	@GetMapping("/chuyenxe/search")
	public String search(@RequestParam("noi-di") String noiDi, @RequestParam("noi-den") String noiDen,
			@RequestParam("ngay-di") String ngayDi, ModelMap modelMap) throws ParseException {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sf.parse(ngayDi);
		modelMap.put("chuyenxe", chuyenXeService.timKiemTheoTuyen(noiDi, noiDen, date));
		return "home/trips";
	}

	public ArrayList<String> spitComment(String comment) {
		ArrayList<String> ls = new ArrayList<>();
		String noiDi = null;
		String noiDen = null;
		String[] c = comment.split("-");
		switch (c[0]) {
		case "hcm":
			noiDi = "Hồ Chí Minh";
			break;
		case "hn":
			noiDi = "Hà Nội";
			break;
		case "dn":
			noiDi = "Đà Nẵng";
			break;
		case "nt":
			noiDi = "Nha Trang";
			break;
		}
		switch (c[1]) {
		case "hcm":
			noiDen = "Hồ Chí Minh";
			break;
		case "hn":
			noiDen = "Hà Nội";
			break;
		case "dn":
			noiDen = "Đà Nẵng";
			break;
		case "nt":
			noiDen = "Nha Trang";
			break;
		}
		ls.add(noiDi);
		ls.add(noiDen);
		return ls;
	}
}
