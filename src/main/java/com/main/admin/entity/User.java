package com.main.admin.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class User {
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@ManyToOne
	@JoinColumn(name = "nha_xe")
	private NhaXe nhaXe;
	
	@Column(name = "ten_dang_nhap")
	private String tenDangNhap;
	
	@Column(name = "mat_khau")
	private String matKhau;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "sdt")
	private String sdt;
	
	@ManyToOne
	@JoinColumn(name = "role")
	private Role role;
	public User() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public NhaXe getNhaXe() {
		return nhaXe;
	}
	public void setNhaXe(NhaXe nhaXe) {
		this.nhaXe = nhaXe;
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
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSdt() {
		return sdt;
	}
	public void setSdt(String sdt) {
		this.sdt = sdt;
	}
	public User(NhaXe nhaXe, String tenDangNhap, String matKhau, String email, String sdt, Role role) {
		super();
		this.nhaXe = nhaXe;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.email = email;
		this.sdt = sdt;
		this.role = role;
	}
	public User(int id, NhaXe nhaXe, String tenDangNhap, String matKhau, String email, String sdt, Role role) {
		super();
		this.id = id;
		this.nhaXe = nhaXe;
		this.tenDangNhap = tenDangNhap;
		this.matKhau = matKhau;
		this.email = email;
		this.sdt = sdt;
		this.role = role;
	}
	
}
