package com.certifier.rest.service;

import java.io.IOException;
import java.util.LinkedList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.solr.client.solrj.SolrServerException;

import com.certifier.rest.solr.QuestionSearchResult;
import com.certifier.rest.solr.SolrSearchResponse;
import com.certifier.rest.solr.SolrSearcher;

/**
 * Servlet implementation class SolrSearchController
 */
public class SolrSearchController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SolrSearchController() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		SolrSearcher searcher = new SolrSearcher();
		String query = request.getParameter("text_search");
		int pageNumber = 1;
		String facetField = "";
		if (StringUtils.isNotBlank(request.getParameter("p_No"))) {
			pageNumber = Integer.valueOf(request.getParameter("p_No"));
		}
		if (StringUtils.isNotBlank(request.getParameter("category"))) {
			facetField = request.getParameter("category");
		}
		try {
			SolrSearchResponse solrResponse = searcher.searchQuestion(query,
					pageNumber, facetField);
			LinkedList<QuestionSearchResult> results = solrResponse
					.getSearchResult();
			if (results != null && results.size() > 1 && results.get(0) != null) {
				long noOfPages = 1;
				if (results.get(0).getNumFound() % 10 == 0) {
					noOfPages = (results.get(0).getNumFound() / 10);
				} else {
					noOfPages = (results.get(0).getNumFound() / 10) + 1;

				}
				request.setAttribute("text_search", query);
				request.setAttribute("noOfPages", noOfPages);
			}
			request.setAttribute("results", results);
			request.setAttribute("facets", solrResponse.getFacetField());
			// request.getRequestDispatcher(
			// "/WEB-INF/jsp/search/search_results.jsp").forward(request,
			// response);
			request.getRequestDispatcher("search_results.jsp").forward(request,
					response);
			// response.getWriter().print(results);
		} catch (SolrServerException e) {
			e.printStackTrace();
			throw new ServletException(e);
			// request.getRequestDispatcher("error.jsp")
			// .forward(request, response);
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
