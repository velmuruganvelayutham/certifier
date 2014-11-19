package com.certifier.rest.solr;

import org.apache.solr.client.solrj.response.FacetField;

public class QuestionSearchResult {

	private long numFound;
	private String id;
	private String question;
	private String category;
	private FacetField facetFieldResult;

	public QuestionSearchResult() {
		// TODO Auto-generated constructor stub
	}

	public QuestionSearchResult(long numFound, String id, String question,
			String category, FacetField facetFieldResult) {
		super();
		this.numFound = numFound;
		this.id = id;
		this.question = question;
		this.category = category;
		this.facetFieldResult = facetFieldResult;
	}

	public QuestionSearchResult(long numFound, String id, String question,
			String category) {
		super();
		this.numFound = numFound;
		this.id = id;
		this.question = question;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "QuestionSearchResult [numFound=" + numFound + ", id=" + id
				+ ", question=" + question + ", category=" + category
				+ ", facetFieldResult=" + facetFieldResult + "]";
	}

	public long getNumFound() {
		return numFound;
	}

	public void setNumFound(long numFound) {
		this.numFound = numFound;
	}

	public FacetField getFacetFieldResult() {
		return facetFieldResult;
	}

	public void setFacetFieldResult(FacetField facetFieldResult) {
		this.facetFieldResult = facetFieldResult;
	}

}
