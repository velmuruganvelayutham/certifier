package com.velmurugan.certifier.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable = false)
	private String username;

	@Column(nullable = false)
	private String password;

	@Column(name = "enabled")
	private Boolean isEnabled;

	// bi-directional many-to-one association to COption
	@OneToMany(mappedBy = "username", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<UserRoles> userRoles = new LinkedHashSet<UserRoles>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Boolean getIsEnabled() {
		return isEnabled;
	}

	public void setIsEnabled(Boolean isEnabled) {
		this.isEnabled = isEnabled;
	}

	public Set<UserRoles> getUserRoles() {
		return userRoles;
	}

	public void setUserRoles(Set<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

	public UserRoles addUserRole(UserRoles userRole) {
		getUserRoles().add(userRole);
		userRole.setUsername(this);

		return userRole;
	}

	public UserRoles removeCOption(UserRoles userRole) {
		getUserRoles().remove(userRole);
		userRole.setUsername(null);

		return userRole;
	}

}
