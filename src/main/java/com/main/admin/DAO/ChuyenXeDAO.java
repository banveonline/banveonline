package com.main.admin.DAO;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.admin.entity.ChuyenXe;


@Repository
public interface ChuyenXeDAO extends CrudRepository<ChuyenXe, Integer>{
	
}
