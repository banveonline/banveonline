package com.main.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "nhaxe")
public class NhaXe implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id_nx;
	
	@Column(name = "anh")
	private String anh;
	
	@Column(name = "ten_nha_xe")
	private String tenNhaXe;
	
	@Column(name = "mo_ta")
	private String moTa;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "dia_chi")
	private String diaChi;

	public NhaXe() {
		// TODO Auto-generated constructor stub
	}
	

	public NhaXe(int id_nx, String anh, String tenNhaXe, String moTa, String sdt, String diaChi) {
		super();
		this.id_nx = id_nx;
		this.anh = anh;
		this.tenNhaXe = tenNhaXe;
		this.moTa = moTa;
		this.sdt = sdt;
		this.diaChi = diaChi;
	}




	public NhaXe(int id_nx, String tenNhaXe, String moTa) {
		super();
		this.id_nx = id_nx;
		this.tenNhaXe = tenNhaXe;
		this.moTa = moTa;
	}

	public int getId_nx() {
		return id_nx;
	}

	public void setId_nx(int id_nx) {
		this.id_nx = id_nx;
	}

	public String getTenNhaXe() {
		return tenNhaXe;
	}

	public void setTenNhaXe(String tenNhaXe) {
		this.tenNhaXe = tenNhaXe;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}


	public String getAnh() {
		return anh;
	}


	public void setAnh(String anh) {
		this.anh = anh;
	}


	public String getSdt() {
		return sdt;
	}


	public void setSdt(String sdt) {
		this.sdt = sdt;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}
	
	
}
