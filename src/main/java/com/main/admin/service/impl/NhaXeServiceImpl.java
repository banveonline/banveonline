package com.main.admin.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.admin.DAO.NhaXeDAO;
import com.main.admin.entity.NhaXe;
import com.main.admin.form.CoachForm;
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
	public boolean xoaNhaXe(int id) {
		if(nhaXeDAO.exists(id)) {
			nhaXeDAO.delete(nhaXeDAO.getOne(id));
			return true;
		}
		return false;
	}

	@Override
	public NhaXe luuNhaXe(NhaXe nhaXe) {
		return nhaXeDAO.save(nhaXe);
	}

	@Override
	public NhaXe timNhaXe(int id) {
		return nhaXeDAO.findOne(id);
	}

	@Override
	public List<NhaXe> findAll() {
		// TODO Auto-generated method stub
		return nhaXeDAO.findAll();
	}

	@Override
	public boolean checkNhaXe(String nhaXe) {
		NhaXe nx = nhaXeDAO.findByUserName(nhaXe);
		if(nx != null) {
			return true;
		}
		return false;
	}

	@Override
	public boolean addNhaXe(CoachForm coachForm) {
		NhaXe nx = new NhaXe();
		nx.setAnh(coachForm.getAnh());
		nx.setId_nx(0);
		nx.setTenNhaXe(coachForm.getTenNhaXe());
		nx.setDiaChi(coachForm.getDiaChi());
		nx.setSdt(coachForm.getSdt());
		NhaXe inserted = nhaXeDAO.save(nx);
		if(inserted != null) {
			return true;
		}
		return false;
	}

}
