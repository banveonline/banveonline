package com.main.home.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.main.admin.DAO.ChuyenXeDAO;

@Controller
public class ChuyenXeController {

	@Autowired
	private ChuyenXeDAO chuyenXeDAO;

	@GetMapping(value = "/chuyenxe/{comment}")
	public String index(@PathVariable String comment, ModelMap modelMap) {
		if (comment.equals("all")) {
			modelMap.put("chuyenxe", chuyenXeDAO.findAll());
		} else {
			modelMap.put("chuyenxe",
					chuyenXeDAO.timChuyenXeCungTuyen(spitComment(comment).get(0), spitComment(comment).get(1)));
		}
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
			noiDi = "Hà Nội";
			break;
		case "dn":
			noiDi = "Đà Nẵng";
			break;
		case "nt":
			noiDi = "Nha Trang";
			break;
		}
		ls.add(noiDi);
		ls.add(noiDen);
		return ls;
	}
}
