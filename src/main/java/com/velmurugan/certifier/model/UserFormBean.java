package com.velmurugan.certifier.model;

public class UserFormBean {

	private String email;

	private String password;

	private boolean isAdmin;

	public UserFormBean(String email, String password, boolean isAdmin) {
		super();
		this.email = email;
		this.password = password;
		this.isAdmin = isAdmin;
	}

	public UserFormBean() {
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isAdmin() {
		return isAdmin;
	}

	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}

	@Override
	public String toString() {
		return "UserFormBean [email=" + email + ", password=" + password
				+ ", isAdmin=" + isAdmin + "]";
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
