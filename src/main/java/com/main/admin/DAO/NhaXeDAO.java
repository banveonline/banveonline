package com.main.admin.DAO;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.admin.entity.NhaXe;

public interface NhaXeDAO extends JpaRepository<NhaXe, Integer>{
	@Query("select n from NhaXe n where n.id != 1")
	public List<NhaXe> findAll();
	
	@Query("select a from NhaXe a where a.tenNhaXe = ?1")
	public NhaXe findByUserName(String tenDangNhap);
}
