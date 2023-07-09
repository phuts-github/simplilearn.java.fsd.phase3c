package com.simplilearn.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
public class Users {
	@Id
	private int id;
	private String uName;
	private String uAge;
	private String uPass;

	public Users() {
		super();
	}

	public Users(int id, String uName, String uAge, String uPass) {
		super();
		this.id = id;
		this.uName = uName;
		this.uAge = uAge;
		this.uPass = uPass;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuAge() {
		return uAge;
	}

	public void setuAge(String uAge) {
		this.uAge = uAge;
	}

	public String getuPass() {
		return uPass;
	}

	public void setuPass(String uPass) {
		this.uPass = uPass;
	}

	@Override
	public String toString() {
		return "Users [id=" + id + ", uName=" + uName + ", uAge=" + uAge + ", uPass=" + uPass + "]";
	}

}