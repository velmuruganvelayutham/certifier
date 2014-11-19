package com.certifier.rest.solr;

import java.net.MalformedURLException;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.FacetField;
import org.apache.solr.client.solrj.response.FacetField.Count;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocumentList;

public class SolrSearcher {

	private String url;
	private String core;
	private HttpSolrServer server = null;
	private int numberOfItemsPerPage = 10;

	public SolrSearcher() {
		url = "http://localhost:8983/solr/";
		core = "core0";
		server = new HttpSolrServer(getUrl() + getCore());
		server.setParser(new XMLResponseParser());
	}

	public SolrSearcher(String url, String core) {
		super();
		this.url = url;
		this.core = core;
		server.setParser(new XMLResponseParser());
	}

	public SolrSearchResponse searchQuestion(String queryStr, int pageNumber,
			String facetCategory) throws MalformedURLException,
			SolrServerException {

		HttpSolrServer solr = getServer();
		SolrSearchResponse solrResponse = new SolrSearchResponse();
		LinkedList<QuestionSearchResult> searchResult = new LinkedList<QuestionSearchResult>();
		SolrQuery query = new SolrQuery();
		query.setStart((pageNumber - 1) * numberOfItemsPerPage);
		query.setRows(numberOfItemsPerPage);
		query.setQuery(queryStr);
		if (StringUtils.isNotBlank(facetCategory)) {
			query.addFilterQuery("category:" + facetCategory);
		} else {
			// query.setFields("id", "price", "merchant", "cat", "store");
			// query.set("defType", "edismax");
			query.setFacet(true);
			query.addFacetField("category");
		}
		System.out.println("The actual query is:" + query.toString());
		QueryResponse response = solr.query(query);

		SolrDocumentList results = response.getResults();
		if (!StringUtils.isNotBlank(facetCategory)) {
			List<FacetField> facetFields = response.getFacetFields();
			FacetField facetFieldResult = null;
			for (FacetField facetField : facetFields) {
				facetFieldResult = facetField;
				List<Count> values = facetField.getValues();
				for (Count c : values) {
					System.out.println("facet field: " + facetField.getName()
							+ "values " + c.getName());
				}
				solrResponse.setFacetField(facetField);
			}
		}

		for (int i = 0; i < results.size(); ++i) {
			long numFound = results.getNumFound();
			String id = (String) results.get(i).get("id");
			String question = (String) results.get(i).get("question");
			String category = (String) results.get(i).get("category");
			QuestionSearchResult result = new QuestionSearchResult(numFound,
					id, question, category);
			searchResult.add(result);
			System.out.println(results.get(i));
		}
		solrResponse.setSearchResult(searchResult);
		return solrResponse;
	}

	public String getCore() {
		return core;
	}

	public void setCore(String core) {
		this.core = core;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public HttpSolrServer getServer() {
		return server;
	}

	public void setServer(HttpSolrServer server) {
		this.server = server;
	}

	public static void main(String[] args) throws MalformedURLException,
			SolrServerException {
		new SolrSearcher().searchQuestion("main", 1, null);
	}
}
