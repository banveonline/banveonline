package com.main.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.main.admin.DAO.UserDAO;
import com.main.admin.entity.User;
import com.main.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	@Override
	public User loadUserByUsername(String username) {
		return userDAO.findByUserName(username);
	}
	@Override
	public List<GrantedAuthority> getAuthorities(User user) {
		List<GrantedAuthority> authorities = new ArrayList<>();
		authorities.add(new SimpleGrantedAuthority(user.getRole().getRoleName()));
		return authorities;
	}
	@Override
	public User checkLogin(String userName, String password) {
		return userDAO.findByUserNameAndPassword(userName, password);
	}
	@Override
	public void save(User user) {
		userDAO.save(user);
	}
	@Override
	public DataTablesOutput<User> findAll(DataTablesInput input) {
		// TODO Auto-generated method stub
		return userDAO.findAll(input);
	}
	@Override
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}
	

}
