package com.tocgroup.tradeshow.dao;

public class Page {

	private int pageNo;
	private int pageSize;
	private Long totalNoOfPages;

	public Page() {
	}

	public Page(int page, int size) {
		this.pageNo = page;
		this.pageSize = size;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public Long getTotalNoOfPages() {
		return totalNoOfPages;
	}

	public void setTotalNoOfPages(Long totalNoOfPages) {
		this.totalNoOfPages = totalNoOfPages;
	}

}
