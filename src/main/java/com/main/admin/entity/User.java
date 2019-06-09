package com.main.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nha_xe")
	private int id_nx;
	
	@Column(name = "ten_dang_nhap")
	private String tenDangNhap;
	
	@Column(name = "mat_khau")
	private String matKhau;
	
	@Column(name = "role")
	private int id_role;
	public User() {
		// TODO Auto-generated constructor stub
	}
	

	public User(int id, int id_nx, String tenDangNhap, String matKhau, int id_role) {
		super();
		this.id = id;
		this.id_nx = id_nx;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.id_role = id_role;
	}


	public User(int id_nx, String tenDangNhap, String matKhau, int id_role) {
		super();
		this.id_nx = id_nx;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.id_role = id_role;
	}


	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId_nx() {
		return id_nx;
	}

	public void setId_nx(int id_nx) {
		this.id_nx = id_nx;
	}

	public String getTenDangNhap() {
		return tenDangNhap;
	}

	public void setTenDangNhap(String tenDangNhap) {
		this.tenDangNhap = tenDangNhap;
	}

	public String getMatKhau() {
		return matKhau;
	}

	public void setMatKhau(String matKhau) {
		this.matKhau = matKhau;
	}

	public int getId_role() {
		return id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}
	
	
}
