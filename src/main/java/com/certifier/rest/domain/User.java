package com.certifier.rest.domain;

public class User {

	@Override
	public String toString() {
		return "User [id=" + id + ", emailid=" + emailid + ", password="
				+ password + ", role=" + role + "]";
	}

	private int id;
	private String emailid;
	private String password;
	private String role;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEmailid() {
		return emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public User() {
	}

}
