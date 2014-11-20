package com.tocgroup.tradeshow.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "vendor", schema = "tradeshow")
public class Vendor implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@Column
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long vendor_id;
	@Column(nullable = false)
	private String showName;
	@Column
	private Date showStartDate;
	@Column
	private Date showEndDate;
	@Column(nullable = false)
	private String vendorName;
	private String boothNo;
	@Column
	private String address;
	@Column
	private String phone;
	@Column
	private String website;
	@Column(length = 10000)
	private String email;
	@Column
	private String fax;
	@Column(length = 10000)
	private String description;

	public String getFax() {
		return fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor")
	private List<Product> products;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "vendor")
	private List<Category> categories;

	public Long getVendor_id() {
		return vendor_id;
	}

	public void setVendor_id(Long vendor_id) {
		this.vendor_id = vendor_id;
	}

	public String getShowName() {
		return showName;
	}

	public void setShowName(String showName) {
		this.showName = showName;
	}

	public Date getShowStartDate() {
		return showStartDate;
	}

	public void setShowStartDate(Date showStartDate) {
		this.showStartDate = showStartDate;
	}

	public Date getShowEndDate() {
		return showEndDate;
	}

	public void setShowEndDate(Date showEndDate) {
		this.showEndDate = showEndDate;
	}

	public String getVendorName() {
		return vendorName;
	}

	public void setVendorName(String vendorName) {
		this.vendorName = vendorName;
	}

	public String getBoothNo() {
		return boothNo;
	}

	public void setBoothNo(String boothNo) {
		this.boothNo = boothNo;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	@Override
	public String toString() {
		return "Vendor [vendor_id=" + vendor_id + ", showName=" + showName
				+ ", showStartDate=" + showStartDate + ", showEndDate="
				+ showEndDate + ", vendorName=" + vendorName + ", boothNo="
				+ boothNo + ", address=" + address + ", phone=" + phone
				+ ", website=" + website + ", email=" + email
				+ ", description=" + description;
	}

}
