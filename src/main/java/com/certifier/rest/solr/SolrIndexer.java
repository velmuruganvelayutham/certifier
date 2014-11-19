package com.certifier.rest.solr;

import java.io.IOException;
import java.util.List;

import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.common.SolrInputDocument;

import com.certifier.rest.dao.QuestionDao;
import com.certifier.rest.dao.QuestionDaoImpl;
import com.certifier.rest.entity.CQuestion;

public class SolrIndexer {
	private String url;
	private String core;
	private HttpSolrServer server = null;

	public SolrIndexer() {
		url = "http://localhost:8983/solr/";
		core = "core0";
		server = new HttpSolrServer(getUrl() + getCore());
		server.setParser(new XMLResponseParser());
	}

	public SolrIndexer(String url, String core) {
		super();
		this.url = url;
		this.core = core;
		server.setParser(new XMLResponseParser());
	}

	// public void indexQuestions() throws SolrServerException, IOException {
	// HttpSolrServer server = getServer();
	// for (int i = 0; i < 1000; ++i) {
	// SolrInputDocument doc = new SolrInputDocument();
	//
	// doc.addField("id", "question-" + i);
	// doc.addField("question", "The Legend of the Hobbit part " + i);
	// doc.addField("questionNo", i);
	// doc.addField("category", "scjp");
	// server.add(doc);
	// if (i % 100 == 0)
	// System.out.println("flushing " + i % 100);
	// server.commit(); // periodically flush
	// }
	// server.commit();
	// }

	public void indexQuestions() throws SolrServerException, IOException {
		HttpSolrServer server = getServer();
		QuestionDao qDao = new QuestionDaoImpl();
		List<CQuestion> questionList = qDao.list();
		int flush = 0;
		for (CQuestion question : questionList) {

			SolrInputDocument doc = new SolrInputDocument();
			doc.addField("id", question.getCQuestionsId());
			doc.addField("question", question.getQuestion());
			doc.addField("questionNo", question.getQuestionno());
			doc.addField("category", question.getCategory());
			server.add(doc);
			System.out.println("indexed question " + question);
			if (flush == 10)
				server.commit(); // periodically flush
		}
		server.commit();
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
}
