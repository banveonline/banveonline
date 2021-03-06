package com.main.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.main.admin.service.ChuyenXeService;
import com.main.admin.service.NhaXeService;
import com.main.admin.service.RoleService;
import com.main.admin.service.ThanhPhoService;
import com.main.admin.service.UserService;
import com.main.admin.entity.NhaXe;
import com.main.admin.entity.Role;
import com.main.admin.entity.User;

@Controller
public class IndexController {
	static boolean start = true; 
	@Autowired
	private ThanhPhoService thanhPhoService;
	@Autowired
	private ChuyenXeService chuyenXeService;
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
	@Autowired
	private NhaXeService nhaXeService;
	@GetMapping(value = "/")
	public String home(ModelMap modelMap) {
		if(start) {
			List<Role> roles = roleService.findByAdminAndMember();
			User user = userService.loadUserByUsername("admin");
			if(roles.isEmpty() && user == null ) {
				roleService.save(new Role("ROLE_ADMIN","ROLE_ADMIN"));
				roleService.save(new Role("ROLE_MEMBER","ROLE_MEMBER"));
				NhaXe nhaxe = new NhaXe();
				nhaxe.setMoTa("admin");
				nhaxe.setId_nx(1);
				nhaxe = nhaXeService.luuNhaXe(nhaxe);
				userService.save(new User(nhaxe,"admin","admin","admin@gmail.com","0123456789",roleService.findByRoleName("ROLE_ADMIN")));
			}
			start = false;
		}
		modelMap.put("thanhpho", thanhPhoService.findAll());
		modelMap.put("saigon_hanoi", chuyenXeService.chuyenXeCungTuyen("Hồ Chí Minh","Hà Nội"));
		return "home/index";
	}
	

}
