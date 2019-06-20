package com.main.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.admin.DAO.VeDAO;
import com.main.admin.entity.Ve;
import com.main.admin.service.VeService;

@Service("VeService")
public class VeServiceImpl implements VeService{
	
	@Autowired
	private VeDAO veDAO;

	@Override
	public Iterable<Ve> danhSachVe(int id_nx) {
		return veDAO.dsChuyenXe(id_nx);
	}

	@Override
	public boolean xoa(int id) {
		if(veDAO.exists(id)) {
			veDAO.delete(veDAO.getOne(id));
			return true;
		}
		return false;
	}

	@Override
	public void luu(Ve ve) {
		veDAO.save(ve);
	}

	@Override
	public Ve tim(int id) {
		return veDAO.findOne(id);
	}

}
