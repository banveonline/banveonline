package com.main.admin.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.main.admin.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>{
	@Query("select a from User a where a.tenDangNhap = ?1 and a.matKhau = ?2")
	User findByUserNameAndPassword(String tenDangNhap, String matKhau);
	
	@Query("select a from User a where a.tenDangNhap = ?1")
	User findByUserName(String tenDangNhap);
	
	@Query("select u from User u where u.role.roleName != 'ROLE_ADMIN'")
	public List<User> findAll();
	
	@Query("select u from User u where u.email = ?1")
	public User findByEmail(String email);
}
