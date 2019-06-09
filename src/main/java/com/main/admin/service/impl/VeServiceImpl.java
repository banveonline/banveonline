package com.main.admin.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.main.admin.DAO.VeDAO;
import com.main.admin.entity.Ve;
import com.main.admin.service.VeService;

public class VeServiceImpl implements VeService{
	
	@Autowired
	private VeDAO veDAO;

	@Override
	public Iterable<Ve> tatCa() {
		return veDAO.findAll();
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
