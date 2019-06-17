package com.main.admin.DAO;

import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.main.admin.entity.User;

@Repository
public interface UserDAO extends JpaRepository<User, Integer>,DataTablesRepository<User, Integer>{
	@Query("select a from User a where a.tenDangNhap = ?1 and a.matKhau = ?2")
	User findByUserNameAndPassword(String tenDangNhap, String matKhau);
	
	@Query("select a from User a where a.tenDangNhap = ?1")
	User findByUserName(String tenDangNhap);
	
	public DataTablesOutput<User> findAll(DataTablesInput input);
}
