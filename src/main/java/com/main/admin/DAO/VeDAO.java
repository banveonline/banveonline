package com.main.admin.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.main.admin.entity.Ve;

public interface VeDAO extends CrudRepository<Ve, Integer>{
	
	@Query("from Ve c where c.chuyenXe.nhaXe.id_nx = ?1")
	public Iterable<Ve> dsChuyenXe(int id_nx); 

}
