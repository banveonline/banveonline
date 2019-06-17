package com.main.admin.service;

import java.util.List;

import com.main.admin.entity.NhaXe;

public interface NhaXeService {
	
	public Iterable<NhaXe> listNhaXe();
	
	public void xoaNhaXe(int id);
	
	public NhaXe luuNhaXe(NhaXe nhaXe);
	
	public NhaXe timNhaXe(int id);
	
	public List<NhaXe> findAll();

}
