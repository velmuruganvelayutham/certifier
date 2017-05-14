package com.velmurugan.certifier.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "user_test")
public class UserTest implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, name = "user_test_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userTestId;

	public Long getUserTestId() {
		return userTestId;
	}

	public void setUserTestId(Long userTestId) {
		this.userTestId = userTestId;
	}

	@ManyToOne
	@JoinColumn(nullable = false, name = "tests_id")
	private CTest test;

	@ManyToOne
	@JoinColumn(name = "username", nullable = false)
	private Users username;

	public CTest getTest() {
		return test;
	}

	public void setTest(CTest test) {
		this.test = test;
	}

	public Boolean getRole() {
		return role;
	}

	public void setRole(Boolean role) {
		this.role = role;
	}

	@Column(name = "enabled")
	private Boolean role;

	public Users getUsername() {
		return username;
	}

	public void setUsername(Users username) {
		this.username = username;
	}

}
