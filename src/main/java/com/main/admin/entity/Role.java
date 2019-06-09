package com.main.admin.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "role")
public class Role implements Serializable{
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "role_name")
	private String roleName;
	
	@Column(name = "mo_ta")
	private String moTa;
	public Role() {
		// TODO Auto-generated constructor stub
	}
	public int getId() {
		return id;
	}
	
	public Role(String roleName, String moTa) {
		super();
		this.roleName = roleName;
		this.moTa = moTa;
	}
	
	public Role(int id, String roleName, String moTa) {
		super();
		this.id = id;
		this.roleName = roleName;
		this.moTa = moTa;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public String getMoTa() {
		return moTa;
	}
	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}
	

}
