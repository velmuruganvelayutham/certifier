package com.certifier.rest.domain;

public class DataTableRequestParam {

	public String getsEcho() {
		return sEcho;
	}

	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	public String getsSearchKeyword() {
		return sSearchKeyword;
	}

	public void setsSearchKeyword(String sSearchKeyword) {
		this.sSearchKeyword = sSearchKeyword;
	}

	public boolean isbRegexKeyword() {
		return bRegexKeyword;
	}

	public void setbRegexKeyword(boolean bRegexKeyword) {
		this.bRegexKeyword = bRegexKeyword;
	}

	public int getiDisplayLength() {
		return iDisplayLength;
	}

	public void setiDisplayLength(int iDisplayLength) {
		this.iDisplayLength = iDisplayLength;
	}

	public int getiDisplayStart() {
		return iDisplayStart;
	}

	public void setiDisplayStart(int iDisplayStart) {
		this.iDisplayStart = iDisplayStart;
	}

	public int getiColumns() {
		return iColumns;
	}

	public void setiColumns(int iColumns) {
		this.iColumns = iColumns;
	}

	public String[] getsSearch() {
		return sSearch;
	}

	public void setsSearch(String[] sSearch) {
		this.sSearch = sSearch;
	}

	public boolean[] getbSearchable() {
		return bSearchable;
	}

	public void setbSearchable(boolean[] bSearchable) {
		this.bSearchable = bSearchable;
	}

	public boolean[] getbSortable() {
		return bSortable;
	}

	public void setbSortable(boolean[] bSortable) {
		this.bSortable = bSortable;
	}

	public boolean[] getbRegex() {
		return bRegex;
	}

	public void setbRegex(boolean[] bRegex) {
		this.bRegex = bRegex;
	}

	public int getiSortingCols() {
		return iSortingCols;
	}

	public void setiSortingCols(int iSortingCols) {
		this.iSortingCols = iSortingCols;
	}

	public String[] getsSortDir() {
		return sSortDir;
	}

	public void setsSortDir(String[] sSortDir) {
		this.sSortDir = sSortDir;
	}

	public int[] getiSortCol() {
		return iSortCol;
	}

	public void setiSortCol(int[] iSortCol) {
		this.iSortCol = iSortCol;
	}

	public String getsColumns() {
		return sColumns;
	}

	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	/**
	 * Request sequence number sent by DataTable, same value must be returned in
	 * response
	 */
	private String sEcho;

	/**
	 * Text used for filtering
	 */
	private String sSearchKeyword;

	/**
	 * Is regular expression search used for filtering
	 */
	private boolean bRegexKeyword;

	/**
	 * Number of records that should be shown in table
	 */
	private int iDisplayLength;

	/**
	 * First record that should be shown(used for paging)
	 */
	private int iDisplayStart;

	/**
	 * Number of columns in table
	 */
	private int iColumns;

	/**
	 * Keywords for the individual column filtering is multi-keyword filtering
	 * is used
	 */
	private String[] sSearch;

	/**
	 * Array that defines what columns are searchable
	 */
	private boolean[] bSearchable;

	/**
	 * Array that defines what columns are sortable
	 */
	private boolean[] bSortable;

	private boolean[] bRegex;

	/**
	 * Number of columns that are used in sorting
	 */
	private int iSortingCols;

	/**
	 * Directions for the column sorting "asc" or "desc"
	 */
	private String[] sSortDir;

	/**
	 * Order of sorting columns
	 */
	private int[] iSortCol;

	/**
	 * Comma separated list of column names
	 */
	private String sColumns;
}
