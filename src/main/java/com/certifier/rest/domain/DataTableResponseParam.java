package com.certifier.rest.domain;

public class DataTableResponseParam {

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public Integer getiTotalRecords() {
		return iTotalRecords;
	}

	public void setiTotalRecords(Integer iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	public Integer getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	public void setiTotalDisplayRecords(Integer iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	public User[][] getAaData() {
		return aaData;
	}

	public void setAaData(User[][] aaData) {
		this.aaData = aaData;
	}

	public DataTableResponseParam() {
		// TODO Auto-generated constructor stub
	}

	private String sEcho;
	private Integer iTotalRecords;
	private Integer iTotalDisplayRecords;
	private User[][] aaData;
}
