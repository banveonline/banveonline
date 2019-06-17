package com.main.admin.service;

import java.util.List;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.core.GrantedAuthority;

import com.main.admin.entity.User;

public interface UserService {
	public User loadUserByUsername(String username);
	public List<GrantedAuthority> getAuthorities(User user);
	public User checkLogin(String userName,String password);
	public DataTablesOutput<User> findAll(DataTablesInput input);
	public List<User> findAll();
	public void save(User user);
}
