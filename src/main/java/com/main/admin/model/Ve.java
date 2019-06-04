package com.main.admin.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "ve")
public class Ve implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "")
	private int id;
	@Column(name = "")
	private int id_CX;
	@Column(name = "")
	private String tenKH;
	@Column(name = "")
	private String sdt;
	@Column(name = "")
	private int soCho;
	@Column(name = "")
	private String ghiChu;

	public Ve(int id, int id_CX, String tenKH, String sdt, int soCho, String ghiChu) {
		super();
		this.id = id;
		this.id_CX = id_CX;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.soCho = soCho;
		this.ghiChu = ghiChu;
	}

	public Ve() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_CX() {
		return id_CX;
	}

	public void setId_CX(int id_CX) {
		this.id_CX = id_CX;
	}

	public String getTenKH() {
		return tenKH;
	}

	public void setTenKH(String tenKH) {
		this.tenKH = tenKH;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public int getSoCho() {
		return soCho;
	}

	public void setSoCho(int soCho) {
		this.soCho = soCho;
	}

	public String getGhiChu() {
		return ghiChu;
	}

	public void setGhiChu(String ghiChu) {
		this.ghiChu = ghiChu;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
