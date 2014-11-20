package com.tocgroup.tradeshow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user", schema = "tradeshow")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer user_id;
	@Column(nullable = false)
	private String username;
	@Column(nullable = false)
	private String password;
	@Column
	private String email;
	@Column
	private String role;
}
