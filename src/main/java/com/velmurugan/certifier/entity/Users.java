package com.velmurugan.certifier.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class Users implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column(nullable = false, length = 1000)
	private String username;
	@Column(nullable = false, length = 1000)
	private String password;
	@Column
	private Boolean isEnabled;
}
