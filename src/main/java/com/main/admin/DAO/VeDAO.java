package com.main.admin.DAO;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.main.admin.entity.Ve;

public interface VeDAO extends JpaRepository<Ve, Integer>{
	
	@Query("from Ve c where c.chuyenXe.nhaXe.id_nx = ?1")
	public Iterable<Ve> dsChuyenXe(int id_nx); 

}
