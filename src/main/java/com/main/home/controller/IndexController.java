package com.main.home.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;

import com.main.admin.service.ChuyenXeService;
import com.main.admin.service.RoleService;
import com.main.admin.service.ThanhPhoService;
import com.main.admin.service.UserService;
import com.main.admin.entity.ChuyenXe;
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
	@GetMapping(value = "/")
	public String home(ModelMap modelMap) {
		if(start) {
			List<Role> roles = roleService.findByAdminAndMember();
			User user = userService.loadUserByUsername("admin");
			if(roles.isEmpty() && user == null ) {
				roleService.save(new Role("ROLE_ADM7IN","ROLE_ADMIN"));
				roleService.save(new Role("ROLE_MEMBER","ROLE_MEMBER"));
				userService.save(new User(0,"admin","admin",roleService.findByRoleName("ROLE_ADMIN")));
			}
			start = false;
		}
		modelMap.put("thanhpho", thanhPhoService.findAll());
		modelMap.put("saigon_hanoi", chuyenXeService.chuyenXeCungTuyen("Hồ Chí Minh","Hà Nội"));
		return "home/index";
	}
	

}
