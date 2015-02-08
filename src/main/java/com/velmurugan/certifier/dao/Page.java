package com.velmurugan.certifier.dao;

public class Page {

	private int offset;
	private int limit;
	private Long totalNoOfPages;

	public int getOffset() {
		return offset;
	}

	public void setOffset(int offset) {
		this.offset = offset;
	}

	public int getLimit() {
		return limit;
	}

	public void setLimit(int limit) {
		this.limit = limit;
	}

	public Long getTotalNoOfPages() {
		return totalNoOfPages;
	}

	public void setTotalNoOfPages(Long totalNoOfPages) {
		this.totalNoOfPages = totalNoOfPages;
	}

	public Page() {
	}

	public Page(int offset, int limit) {
		this.offset = offset;
		this.limit = limit;
	}

}
