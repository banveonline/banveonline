package com.main.admin.service;

import java.util.List;

import com.main.admin.entity.NhaXe;
import com.main.admin.form.CoachForm;

public interface NhaXeService {
	
	public Iterable<NhaXe> listNhaXe();
	
	public boolean xoaNhaXe(int id);
	
	public NhaXe luuNhaXe(NhaXe nhaXe);
	
	public NhaXe timNhaXe(int id);
	
	public List<NhaXe> findAll();

	public boolean checkNhaXe(String nhaXe);
	
	public boolean addNhaXe(CoachForm coachForm);
}
