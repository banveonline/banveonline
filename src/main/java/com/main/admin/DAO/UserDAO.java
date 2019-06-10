package com.main.admin.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.admin.entity.User;

@Repository
public interface UserDAO extends CrudRepository<User, Integer>{
	@Query("select a from User a where a.tenDangNhap = ?1 and a.matKhau = ?2")
	User findByUserNameAndPassword(String tenDangNhap, String matKhau);
	
	@Query("select a from User a where a.tenDangNhap = ?1")
	User findByUserName(String tenDangNhap);
}
