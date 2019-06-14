package com.main.admin.service;

import java.util.List;

import com.main.admin.entity.Role;

public interface RoleService {
	public Role findByRoleName(String roleName);
	public void save(Role role);
	public List<Role> findByAdminAndMember();
}
