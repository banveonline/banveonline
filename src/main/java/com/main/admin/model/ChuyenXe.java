package com.main.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "chuyenxe")
public class ChuyenXe implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_cx")
	private int id_CX;
	
	@Column(name = "id_nx")
	private int id_nx;
	
	@Column(name = "gadi")
	private String gaDi;
	
	@Column(name = "gaden")
	private String gaDen;
	
	@Column(name = "songuoi")
	private int soNguoi;
	
	@Column(name = "gia")
	private double gia;
	
	@Column(name = "mota")
	private String moTa;

	public ChuyenXe(int id_CX, int id_nx, String gaDi, String gaDen, int soNguoi, double gia, String moTa) {
		super();
		this.id_CX = id_CX;
		this.id_nx = id_nx;
		this.gaDi = gaDi;
		this.gaDen = gaDen;
		this.soNguoi = soNguoi;
		this.gia = gia;
		this.moTa = moTa;
	}

	public ChuyenXe() {
		super();
	}

	public int getId_CX() {
		return id_CX;
	}

	public void setId_CX(int id_CX) {
		this.id_CX = id_CX;
	}

	public int getId_nx() {
		return id_nx;
	}

	public void setId_nx(int id_nx) {
		this.id_nx = id_nx;
	}

	public String getGaDi() {
		return gaDi;
	}

	public void setGaDi(String gaDi) {
		this.gaDi = gaDi;
	}

	public String getGaDen() {
		return gaDen;
	}

	public void setGaDen(String gaDen) {
		this.gaDen = gaDen;
	}

	public int getSoNguoi() {
		return soNguoi;
	}

	public void setSoNguoi(int soNguoi) {
		this.soNguoi = soNguoi;
	}

	public double getGia() {
		return gia;
	}

	public void setGia(double gia) {
		this.gia = gia;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	
	
	
}
