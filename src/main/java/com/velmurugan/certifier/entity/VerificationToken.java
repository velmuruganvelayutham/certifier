package com.velmurugan.certifier.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "verification_token", schema = "tradeshow")
public class VerificationToken implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer verification_id;

	@Column
	private String token;

	@OneToOne
	@JoinColumn(name = "username")
	private Users users;

	public Integer getVerification_id() {
		return verification_id;
	}

	public void setVerification_id(Integer verification_id) {
		this.verification_id = verification_id;
	}

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public Users getUsers() {
		return users;
	}

	public void setUsers(Users users) {
		this.users = users;
	}

}
