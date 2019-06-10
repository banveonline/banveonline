package com.main.admin.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.main.admin.entity.ChuyenXeCungTuyen;

@Repository
public interface ChuyenXeCungTuyenDAO extends CrudRepository<ChuyenXeCungTuyen, Integer>{

	@Query("SELECT c.id_CX, c.gia, c.gioDi, c.id_nx, c.ngayDi, n.tenNhaXe FROM NhaXe n, ChuyenXe c WHERE n.id_nx = c.id_nx AND c.id_nx IN (SELECT c.id_nx FROM ChuyenXe c WHERE c.gaDi = ?1)")
	public Iterable<ChuyenXeCungTuyen> listChuyenXeCungThuyen(String gaDi);
}
