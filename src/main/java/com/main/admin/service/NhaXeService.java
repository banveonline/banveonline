package com.main.admin.service;

import com.main.admin.entity.NhaXe;

public interface NhaXeService {
	
	public Iterable<NhaXe> listNhaXe();
	
	public void xoaNhaXe(int id);
	
	public NhaXe luuNhaXe(NhaXe nhaXe);
	
	public NhaXe timNhaXe(int id);

}
