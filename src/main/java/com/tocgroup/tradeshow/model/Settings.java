package com.tocgroup.tradeshow.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "settings", schema = "tradeshow")
public class Settings implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long settings_id;
	@Column(nullable = true, length = 512)
	private String websiteName;
	@Column(nullable = false, length = 1024)
	private String url;

	public Long getSettings_id() {
		return settings_id;
	}

	public void setSettings_id(Long settings_id) {
		this.settings_id = settings_id;
	}

	public String getWebsiteName() {
		return websiteName;
	}

	public void setWebsiteName(String websiteName) {
		this.websiteName = websiteName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

}
