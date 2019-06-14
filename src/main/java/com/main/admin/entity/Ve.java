package com.main.admin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "ve")
public class Ve implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "chuyen_xe")
	private int id_CX;
	
	@Column(name = "ten_khach_hang")
	private String tenKH;
	
	@Column(name = "sdt")
	private String sdt;
	
	@Column(name = "cmnd")
	private String cnmd;
	
	@Column(name = "so_ghe")
	private int soCho;
	
	@Column(name = "ghi_chu")
	private String ghiChu;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ngay_dat_ve")
	private Date ngayDatVe;

	
	public Ve(int id, int id_CX, String tenKH, String sdt, String cnmd, int soCho, String ghiChu, Date ngayDatVe) {
		super();
		this.id = id;
		this.id_CX = id_CX;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.cnmd = cnmd;
		this.soCho = soCho;
		this.ghiChu = ghiChu;
		this.ngayDatVe = ngayDatVe;
	}
	

	public Ve(int id_CX, String tenKH, String sdt, String cnmd, int soCho, String ghiChu, Date ngayDatVe) {
		super();
		this.id_CX = id_CX;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.cnmd = cnmd;
		this.soCho = soCho;
		this.ghiChu = ghiChu;
		this.ngayDatVe = ngayDatVe;
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


	public String getCnmd() {
		return cnmd;
	}


	public void setCnmd(String cnmd) {
		this.cnmd = cnmd;
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


	public Date getNgayDatVe() {
		return ngayDatVe;
	}


	public void setNgayDatVe(Date ngayDatVe) {
		this.ngayDatVe = ngayDatVe;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
