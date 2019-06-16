package com.main.admin.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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

	@ManyToOne
	@JoinColumn(name = "chuyen_xe")
	private ChuyenXe chuyenXe;

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

	@Column(name = "gia")
	private int gia;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "ngay_dat_ve")
	private Date ngayDatVe;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ChuyenXe getChuyenxe() {
		return chuyenXe;
	}

	public void setChuyenxe(ChuyenXe chuyenxe) {
		this.chuyenXe = chuyenxe;
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

	public int getGia() {
		return gia;
	}

	public void setGia(int gia) {
		this.gia = gia;
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

	public Ve(ChuyenXe chuyenxe, String tenKH, String sdt, String cnmd, int soCho, String ghiChu, int gia,
			Date ngayDatVe) {
		super();
		this.chuyenXe = chuyenxe;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.cnmd = cnmd;
		this.soCho = soCho;
		this.ghiChu = ghiChu;
		this.gia = gia;
		this.ngayDatVe = ngayDatVe;
	}

	public Ve(int id, ChuyenXe chuyenxe, String tenKH, String sdt, String cnmd, int soCho, String ghiChu, int gia,
			Date ngayDatVe) {
		super();
		this.id = id;
		this.chuyenXe = chuyenxe;
		this.tenKH = tenKH;
		this.sdt = sdt;
		this.cnmd = cnmd;
		this.soCho = soCho;
		this.ghiChu = ghiChu;
		this.gia = gia;
		this.ngayDatVe = ngayDatVe;
	}

	public Ve() {
		// TODO Auto-generated constructor stub
	}

}
