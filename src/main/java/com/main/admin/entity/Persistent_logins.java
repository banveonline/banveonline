package com.main.admin.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "persistent_logins")
public class Persistent_logins {
	@Column(name = "username")
	private String username;
	
	@Column(name = "series")
	private String series;
	
	@Id
	@Column(name = "token")
	private String token;
	
	@Column(name = "last_used")
	private Date last_used;
	
	public Persistent_logins() {
		// TODO Auto-generated constructor stub
	}

	
	public Persistent_logins(String username, String series, String token, Date last_used) {
		super();
		this.username = username;
		this.series = series;
		this.token = token;
		this.last_used = last_used;
	}


	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSeries() {
		return series;
	}

	public void setSeries(String series) {
		this.series = series;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Date getLast_used() {
		return last_used;
	}

	public void setLast_used(Date last_used) {
		this.last_used = last_used;
	}
	
}
