package com.main.admin.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.main.admin.entity.ChuyenXe;

public interface ChuyenXeDAO extends CrudRepository<ChuyenXe, Integer>{
	
	@Query("SELECT * FROM chuyenxe WHERE chuyenxe.gadi = ?1")
	public Iterable<ChuyenXe> timChuyenXeTheoNoiDi(String noiDi);
}
