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

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "chuyenxe")
public class ChuyenXe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id_cx", nullable = false)
	private int id_CX;

	@ManyToOne
	@JoinColumn(name = "id_nx")
	@JsonIgnore
	private NhaXe nhaXe;

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

	@Column(name = "giodi")
	private String gioDi;

	@Temporal(TemporalType.DATE)
	@Column(name = "ngaydi")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date ngayDi;

	public ChuyenXe() {
		// TODO Auto-generated constructor stub
	}

	public ChuyenXe(NhaXe nhaXe, String gaDi, String gaDen, int soNguoi, double gia, String moTa, String gioDi,
			Date ngayDi) {
		super();
		this.nhaXe = nhaXe;
		this.gaDi = gaDi;
		this.gaDen = gaDen;
		this.soNguoi = soNguoi;
		this.gia = gia;
		this.moTa = moTa;
		this.gioDi = gioDi;
		this.ngayDi = ngayDi;
	}

	public ChuyenXe(int id_CX, NhaXe nhaXe, String gaDi, String gaDen, int soNguoi, double gia, String moTa,
			String gioDi, Date ngayDi) {
		super();
		this.id_CX = id_CX;
		this.nhaXe = nhaXe;
		this.gaDi = gaDi;
		this.gaDen = gaDen;
		this.soNguoi = soNguoi;
		this.gia = gia;
		this.moTa = moTa;
		this.gioDi = gioDi;
		this.ngayDi = ngayDi;
	}

	public int getId_CX() {
		return id_CX;
	}

	public void setId_CX(int id_CX) {
		this.id_CX = id_CX;
	}

	public NhaXe getNhaXe() {
		return nhaXe;
	}

	public void setNhaXe(NhaXe nhaXe) {
		this.nhaXe = nhaXe;
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

	public String getGioDi() {
		return gioDi;
	}

	public void setGioDi(String gioDi) {
		this.gioDi = gioDi;
	}

	public Date getNgayDi() {
		return ngayDi;
	}

	public void setNgayDi(Date ngayDi) {
		this.ngayDi = ngayDi;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
}
