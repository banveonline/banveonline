package com.main.admin.service;

import com.main.admin.model.ThanhPho;

public interface ThanhPhoService {
	
	public Iterable<ThanhPho> findAll();
	
	public ThanhPho tim(String ten);

}
