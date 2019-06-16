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
	public Iterable<Ve> danhSachVe(Iterable<Integer> id_nx) {
		return veDAO.findAll(id_nx);
	}

	@Override
	public void xoa(int id) {
		veDAO.delete(id);
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
