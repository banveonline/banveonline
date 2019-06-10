package com.main.admin.service;

import com.main.admin.entity.ChuyenXe;

public interface ChuyenXeService {
	
	public Iterable<ChuyenXe> listChuyenXe();
	
	public Iterable<ChuyenXe> timChuyenXeTheoGaDi(String gaDi);
	
	public void xoaChuyenXe(int id);
	
	public void luuChuyenXe(ChuyenXe chuyenXe);
	
	public ChuyenXe tim(int id);
}
