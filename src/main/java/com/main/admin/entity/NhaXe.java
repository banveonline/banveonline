package com.main.admin.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
	
	@Column(name = "ten_nha_xe")
	private String tenNhaXe;
	
	@Column(name = "mo_ta")
	private String moTa;
	
	@OneToMany(mappedBy="nhaXe")
	private List<ChuyenXe> ChuyenXe;

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


	public List<ChuyenXe> getChuyenXe() {
		return ChuyenXe;
	}

	public void setChuyenXe(List<ChuyenXe> chuyenXe) {
		ChuyenXe = chuyenXe;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public NhaXe() {
		// TODO Auto-generated constructor stub
	}

	public NhaXe(String tenNhaXe, String moTa, List<com.main.admin.entity.ChuyenXe> chuyenXe) {
		super();
		this.tenNhaXe = tenNhaXe;
		this.moTa = moTa;
		ChuyenXe = chuyenXe;
	}

	public NhaXe(int id_nx, String tenNhaXe, String moTa, List<com.main.admin.entity.ChuyenXe> chuyenXe) {
		super();
		this.id_nx = id_nx;
		this.tenNhaXe = tenNhaXe;
		this.moTa = moTa;
		ChuyenXe = chuyenXe;
	}

	
	
	
}
