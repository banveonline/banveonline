package com.main.admin.service;

import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import com.main.admin.entity.User;
import com.main.admin.form.UserForm;

public interface UserService {
	public User loadUserByUsername(String username);
	public List<GrantedAuthority> getAuthorities(User user);
	public User checkLogin(String userName,String password);
	public List<User> findAll();
	public void save(User user);
	public boolean checkUserName(String userName);
	public boolean checkEmail(String email);
	public boolean addUser(UserForm userForm);
}
