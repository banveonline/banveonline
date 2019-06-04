package com.main.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.admin.DAO.ThanhPhoDAO;
import com.main.admin.model.ThanhPho;

@Service("ThanhPhoService")
public class ThanhPhoServiceImpl implements ThanhPhoService{
	
	@Autowired
	private ThanhPhoDAO thanhPhoDAO;

	@Override
	public Iterable<ThanhPho> findAll() {
		return thanhPhoDAO.findAll();
	}

	@Override
	public ThanhPho tim(String ten) {
		return thanhPhoDAO.findOne(ten);
	}
	

}
