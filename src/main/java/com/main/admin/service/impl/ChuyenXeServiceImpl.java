package com.main.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.admin.DAO.ChuyenXeDAO;
import com.main.admin.entity.ChuyenXe;
import com.main.admin.service.ChuyenXeService;

@Service("ChuyenXeService")
public class ChuyenXeServiceImpl implements ChuyenXeService{
	
	@Autowired
	private ChuyenXeDAO chuyenXeDAO;

	@Override
	public Iterable<ChuyenXe> listChuyenXe(int id_nx) {
		return chuyenXeDAO.dsChuyenXe(id_nx);
	}

	@Override
	public void xoaChuyenXe(int id) {
		chuyenXeDAO.delete(id);
	}

	@Override
	public void luuChuyenXe(ChuyenXe chuyenXe) {
		chuyenXeDAO.save(chuyenXe);
	}

	@Override
	public ChuyenXe tim(int id) {
		return chuyenXeDAO.findOne(id);
	}

	@Override
	public Iterable<ChuyenXe> timChuyenXeTheoGaDi(String gaDi) {
		return chuyenXeDAO.timChuyenXeTheoGaDi(gaDi);
	}

	@Override
	public Iterable<ChuyenXe> chuyenXeCungTuyen(String gaDi, String gaDen) {
		return chuyenXeDAO.timChuyenXeCungTuyen(gaDi, gaDen);
	}


}
