package com.main.admin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table( name = "chuyen_xe_cung_tuyen")
public class ChuyenXeCungTuyen implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_cx")
	private int id_cx;
	@Column(name = "gia")
	private double gia;
	@Column(name = "gio_di")
	private String gioDi;
	@Column(name = "id_nx")
	private int id_nx;
	@Temporal(TemporalType.DATE)
	@Column(name = "ngay_di")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngayDi;
	@Column(name = "tennx")
	private String tenNX;
	public ChuyenXeCungTuyen(int id_cx, int id_nx, String tenNX, Date ngayDi, double gia, String gioDi) {
		super();
		this.id_cx = id_cx;
		this.id_nx = id_nx;
		this.tenNX = tenNX;
		this.ngayDi = ngayDi;
		this.gia = gia;
		this.gioDi = gioDi;
	}
	public ChuyenXeCungTuyen() {
		super();
	}
	public int getId_cx() {
		return id_cx;
	}
	public void setId_cx(int id_cx) {
		this.id_cx = id_cx;
	}
	public int getId_nx() {
		return id_nx;
	}
	public void setId_nx(int id_nx) {
		this.id_nx = id_nx;
	}
	public String getTenNX() {
		return tenNX;
	}
	public void setTenNX(String tenNX) {
		this.tenNX = tenNX;
	}
	public Date getNgayDi() {
		return ngayDi;
	}
	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}
	public double getGia() {
		return gia;
	}
	public void setGia(double gia) {
		this.gia = gia;
	}
	public String getGioDi() {
		return gioDi;
	}
	public void setGioDi(String gioDi) {
		this.gioDi = gioDi;
	}
	

	
}
