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
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "user_roles", uniqueConstraints = {
		@UniqueConstraint(columnNames = { "username", "ROLE" }) })
public class UserRoles implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column(nullable = false, name = "user_role_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userRolesId;

	@ManyToOne
	@JoinColumn(name = "username", nullable = false)
	private Users username;

	@Column(name = "ROLE")
	private String role;

	public Long getUserRolesId() {
		return userRolesId;
	}

	public void setUserRolesId(Long userRolesId) {
		this.userRolesId = userRolesId;
	}

	public Users getUsername() {
		return username;
	}

	public void setUsername(Users username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

}
