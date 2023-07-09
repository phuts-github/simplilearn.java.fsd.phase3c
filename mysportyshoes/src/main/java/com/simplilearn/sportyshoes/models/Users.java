package com.simplilearn.sportyshoes.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	@Column(unique=true)
	private String email;
	private String name;
	private String pass;
	private String admin;
	private String adminPass;
	private String address;
	public Users() {
		super();
	}
	public Users(int id, String email, String name, String pass, String admin, String adminPass, String address) {
		super();
		this.id = id;
		this.email = email;
		this.name = name;
		this.pass = pass;
		this.admin = admin;
		this.adminPass = adminPass;
		this.address = address;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public String getAdmin() {
		return admin;
	}
	public void setAdmin(String admin) {
		this.admin = admin;
	}
	public String getAdminPass() {
		return adminPass;
	}
	public void setAdminPass(String adminPass) {
		this.adminPass = adminPass;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "Users [id=" + id + ", email=" + email + ", name=" + name + ", pass=" + pass + ", admin=" + admin
				+ ", adminPass=" + adminPass + ", address=" + address + "]";
	}

}
