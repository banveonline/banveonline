package com.main.admin.DAO;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.admin.entity.ChuyenXe;

@Repository
public interface ChuyenXeDAO extends CrudRepository<ChuyenXe, Integer>{
	
	@Query("from ChuyenXe c where c.nhaXe.id_nx = ?1")
	public Iterable<ChuyenXe> dsChuyenXe(int id_nx); 
	
	@Query("from ChuyenXe c where c.gaDi = ?1")
	public Iterable<ChuyenXe> timChuyenXeTheoGaDi(String gaDi); 
	
	@Query("from ChuyenXe c where c.gaDi = ?1 AND c.gaDen = ?2")
	public Iterable<ChuyenXe> timChuyenXeCungTuyen(String gaDi, String gaDen);
	
	@Query("FROM ChuyenXe c WHERE c.gaDi = ?1 AND c.gaDen = ?2 AND c.ngayDi = ?3")
	public Iterable<ChuyenXe> timChuyenXe(String gaDi, String gaDen, Date ngayDi);
	
}
