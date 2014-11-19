package com.certifier.rest.domain;

public class DataTableUpdateParam {

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getColumnName() {
		return columnName;
	}

	public void setColumnName(String columnName) {
		this.columnName = columnName;
	}

	private String value;
	private int id;
	private String columnName;

	public DataTableUpdateParam() {
		// TODO Auto-generated constructor stub
	}

}
