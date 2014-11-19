package com.certifier.rest.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the c_user_profile database table.
 * 
 */
@Entity
@Table(name = "c_user_profile")
@NamedQuery(name = "CUserProfile.findAll", query = "SELECT c FROM CUserProfile c")
public class CUserProfile implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_user_preference_id", unique = true, nullable = false)
	private int cUserPreferenceId;

	@Column(length = 45)
	private String city;

	@Column(length = 45)
	private String country;

	@Column(length = 1000)
	private String description;

	@Column(name = "first_name", length = 45)
	private String firstName;

	@Lob
	private byte[] image;

	@Column(name = "last_name", length = 45)
	private String lastName;

	@Column(length = 45)
	private String phoneno;

	@Column(name = "skype_id", length = 45)
	private String skypeId;

	// bi-directional many-to-one association to CUser
	@ManyToOne
	@JoinColumn(name = "c_user_id", nullable = false)
	private CUser CUser;

	public CUserProfile() {
	}

	public int getCUserPreferenceId() {
		return this.cUserPreferenceId;
	}

	public void setCUserPreferenceId(int cUserPreferenceId) {
		this.cUserPreferenceId = cUserPreferenceId;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public Object getImage() {
		return this.image;
	}

	public void setImage(byte[] image) {
		this.image = image;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getPhoneno() {
		return this.phoneno;
	}

	public void setPhoneno(String phoneno) {
		this.phoneno = phoneno;
	}

	public String getSkypeId() {
		return this.skypeId;
	}

	public void setSkypeId(String skypeId) {
		this.skypeId = skypeId;
	}

	public CUser getCUser() {
		return this.CUser;
	}

	public void setCUser(CUser CUser) {
		this.CUser = CUser;
	}

}