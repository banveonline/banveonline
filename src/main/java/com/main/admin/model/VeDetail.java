package com.main.admin.model;

import java.util.Date;

import com.main.admin.entity.ChuyenXe;
import com.main.admin.entity.Ve;

public class VeDetail extends Ve{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id_CX;
	public VeDetail() {
	}
	public VeDetail(int chuyenxe, String tenKH, String sdt, String cnmd, int soCho, String ghiChu, int gia,
			Date ngayDatVe) {
		super(null, tenKH, sdt, cnmd, soCho, ghiChu, gia, ngayDatVe);
	}
	public int getId_CX() {
		return id_CX;
	}
	public void setId_CX(int id_CX) {
		this.id_CX = id_CX;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public Ve convertToVe(VeDetail veDetail,ChuyenXe chuyenXe) {
		Ve ve = new Ve();
		ve.setChuyenxe(chuyenXe);
		ve.setCnmd(veDetail.getCnmd());
		ve.setGhiChu(veDetail.getGhiChu());
		ve.setTenKH(veDetail.getTenKH());
		ve.setSdt(veDetail.getSdt());
		
		ve.setId(veDetail.getId());
		ve.setSoCho(veDetail.getSoCho());
		ve.setGia(veDetail.getGia());
		ve.setNgayDatVe(veDetail.getNgayDatVe());
		return ve;
	}

	
}
