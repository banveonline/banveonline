package com.main.admin.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import com.main.admin.DAO.NhaXeDAO;
import com.main.admin.DAO.RoleDAO;
import com.main.admin.DAO.UserDAO;
import com.main.admin.entity.NhaXe;
import com.main.admin.entity.Role;
import com.main.admin.entity.User;
import com.main.admin.form.UserForm;
import com.main.admin.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private NhaXeDAO nhaXeRepository;
	@Autowired
	private RoleDAO roleRepository;
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
	public List<User> findAll() {
		// TODO Auto-generated method stub
		return userDAO.findAll();
	}
	@Override
	public boolean checkUserName(String userName) {
		// TODO Auto-generated method stub
		User user = userDAO.findByUserName(userName);
		if(user != null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean checkEmail(String email) {
		// TODO Auto-generated method stub
		User user = userDAO.findByEmail(email.trim());
		if(user != null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean addUser(UserForm userForm) {
		NhaXe nhaxe = nhaXeRepository.findOne(Integer.parseInt(userForm.getNhaXe()));
		Role role = roleRepository.findByRoleName("ROLE_MEMBER");
		User user = new User();
		user.setId(0);
		user.setTenDangNhap(userForm.getTenDangNhap());
		user.setMatKhau(userForm.getMatKhau());
		user.setRole(role);
		user.setNhaXe(nhaxe);
		user.setSdt(userForm.getSdt());
		user.setEmail(userForm.getEmail());
		User inserted = userDAO.save(user);
		if(inserted != null) {
			return true;
		}
		return false;
	}
	@Override
	public boolean delete(int id) {
		if (userDAO.exists(id)) {
			userDAO.delete(userDAO.getOne(id));
			return true;
		}
		return false;
	}
	

}
