package com.certifier.rest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the c_user database table.
 * 
 */
@Entity
@Table(name = "c_user")
@NamedQuery(name = "CUser.findAll", query = "SELECT c FROM CUser c")
public class CUser implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_user_id", unique = true, nullable = false)
	private int cUserId;

	@Column(nullable = false, length = 45)
	private String emailid;

	@Column(nullable = false, length = 45)
	private String password;

	@Column(length = 45)
	private String role;

	// bi-directional many-to-one association to CUserHistory
	@OneToMany(mappedBy = "CUser")
	private List<CUserHistory> CUserHistories;

	// bi-directional many-to-one association to CUserProfile
	@OneToMany(mappedBy = "CUser")
	private List<CUserProfile> CUserProfiles;

	public CUser() {
	}

	public int getCUserId() {
		return this.cUserId;
	}

	public void setCUserId(int cUserId) {
		this.cUserId = cUserId;
	}

	public String getEmailid() {
		return this.emailid;
	}

	public void setEmailid(String emailid) {
		this.emailid = emailid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return this.role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<CUserHistory> getCUserHistories() {
		return this.CUserHistories;
	}

	public void setCUserHistories(List<CUserHistory> CUserHistories) {
		this.CUserHistories = CUserHistories;
	}

	public CUserHistory addCUserHistory(CUserHistory CUserHistory) {
		getCUserHistories().add(CUserHistory);
		CUserHistory.setCUser(this);

		return CUserHistory;
	}

	public CUserHistory removeCUserHistory(CUserHistory CUserHistory) {
		getCUserHistories().remove(CUserHistory);
		CUserHistory.setCUser(null);

		return CUserHistory;
	}

	public List<CUserProfile> getCUserProfiles() {
		return this.CUserProfiles;
	}

	public void setCUserProfiles(List<CUserProfile> CUserProfiles) {
		this.CUserProfiles = CUserProfiles;
	}

	public CUserProfile addCUserProfile(CUserProfile CUserProfile) {
		getCUserProfiles().add(CUserProfile);
		CUserProfile.setCUser(this);

		return CUserProfile;
	}

	public CUserProfile removeCUserProfile(CUserProfile CUserProfile) {
		getCUserProfiles().remove(CUserProfile);
		CUserProfile.setCUser(null);

		return CUserProfile;
	}

}