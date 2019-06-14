package com.main.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.admin.DAO.RoleDAO;
import com.main.admin.entity.Role;
import com.main.admin.service.RoleService;
@Service
public class RoleServiceImlp implements RoleService{
	@Autowired
	private RoleDAO roleRepository;

	@Override
	public Role findByRoleName(String roleName) {
		return roleRepository.findByRoleName(roleName);
	}

	@Override
	public void save(Role role) {
		roleRepository.save(role);
	}

	@Override
	public List<Role> findByAdminAndMember() {
		return roleRepository.findByAdminAndMember();
	}

}
