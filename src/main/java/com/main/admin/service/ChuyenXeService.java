package com.main.admin.service;

import java.util.Date;

import com.main.admin.entity.ChuyenXe;

public interface ChuyenXeService {
	
	public Iterable<ChuyenXe> listChuyenXe();
	
	public Iterable<ChuyenXe> listChuyenXe(int id_nx);
	
	public Iterable<ChuyenXe> timChuyenXeTheoGaDi(String gaDi);
	
	public Iterable<ChuyenXe> chuyenXeCungTuyen(String gaDi,String gaDen);
	
	public Iterable<ChuyenXe> timKiemTheoTuyen(String gaDi,String gaDen,Date ngayDi);
	
	public void xoaChuyenXe(int id);
	
	public void luuChuyenXe(ChuyenXe chuyenXe);
	
	public ChuyenXe tim(int id);
	
}
