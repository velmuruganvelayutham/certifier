package com.certifier.rest.solr;

import java.util.LinkedList;

import org.apache.solr.client.solrj.response.FacetField;

public class SolrSearchResponse {

	private LinkedList<QuestionSearchResult> searchResult = new LinkedList<QuestionSearchResult>();
	private int numFound;
	private FacetField facetField;

	public FacetField getFacetField() {
		return facetField;
	}

	public void setFacetField(FacetField facetField) {
		this.facetField = facetField;
	}

	public int getNumFound() {
		return numFound;
	}

	public void setNumFound(int numFound) {
		this.numFound = numFound;
	}

	public LinkedList<QuestionSearchResult> getSearchResult() {
		return searchResult;
	}

	public void setSearchResult(LinkedList<QuestionSearchResult> searchResult) {
		this.searchResult = searchResult;
	}
}
