package com.main.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.admin.DAO.NhaXeDAO;
import com.main.admin.entity.NhaXe;
import com.main.admin.service.NhaXeService;

@Service("NhaXeService")
public class NhaXeServiceImpl implements NhaXeService{

	@Autowired
	private NhaXeDAO nhaXeDAO;
	@Override
	public Iterable<NhaXe> listNhaXe() {
		return nhaXeDAO.findAll();
	}

	@Override
	public void xoaNhaXe(int id) {
		nhaXeDAO.delete(id);
	}

	@Override
	public void luuNhaXe(NhaXe nhaXe) {
		nhaXeDAO.save(nhaXe);
	}

	@Override
	public NhaXe timNhaXe(int id) {
		return nhaXeDAO.findOne(id);
	}

}
