package com.main.admin.service;

import com.main.admin.entity.Ve;

public interface VeService {

	public Iterable<Ve> danhSachVe(Iterable<Integer> id_nx);
	
	public void xoa(int id);
	
	public void luu(Ve ve);
	
	public Ve tim(int id);
}
