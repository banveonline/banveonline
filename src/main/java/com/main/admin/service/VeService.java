package com.main.admin.service;

import com.main.admin.model.Ve;

public interface VeService {

	public Iterable<Ve> tatCa();
	
	public void xoa(int id);
	
	public void luu(Ve ve);
	
	public Ve tim(int id);
}
