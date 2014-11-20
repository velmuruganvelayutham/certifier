package com.tocgroup.tradeshow.controller;

import java.io.File;
import java.io.IOException;

import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.client.solrj.response.UpdateResponse;
import org.apache.solr.common.SolrDocumentList;
import org.apache.solr.common.SolrInputDocument;
import org.apache.solr.core.CoreContainer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.tocgroup.tradeshow.service.VendorService;

/**
 * Handles requests for the application home page.
 */
@Controller
@RequestMapping("/search")
public class SearchController {

	@Autowired
	VendorService vendorService;
	private static final Logger logger = LoggerFactory
			.getLogger(SearchController.class);

	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody String home(Model model, @RequestParam("q") String q) {
		String name = "{\"first_name\": \"will be implemented soon !...\",\"last_name\": \"Butler\",\"profile_url\": \"/users/78749\"}";
		String response = "[" + name + "," + name + "," + name + "," + name
				+ "," + name + "," + name + "]";
		logger.info("-- > Search controller is called -- > " + "");

		model.addAttribute("message", "Search is coming soon !.");

		return response;
	}

	@RequestMapping(value = "solr", method = RequestMethod.GET)
	public String solr() throws SolrServerException, IOException {
		return test();
	}

	public static void main(String[] args) throws SolrServerException,
			IOException {
		new SearchController().test();
	}

	/**
	 * @return
	 * @throws SolrServerException
	 * @throws IOException
	 */
	public String test() throws SolrServerException, IOException {
		final String baseTempPath = System.getProperty("java.io.tmpdir");
		File tempDir = new File(baseTempPath + File.separator
				+ System.getProperty("user.name") + File.separator + "solrhome");
		if (!tempDir.exists()) {
			tempDir.mkdirs();
		}

		String solrServer = tempDir.getAbsolutePath();
		System.out.println("solr server" + solrServer);
		File solrXml = new File(new File(solrServer), "solr.xml");
		if (!solrXml.exists()) {
			// copyConfigToSolrHome(this.getClass().getResourceAsStream("/solr-default.xml"),
			// solrXml);
		}
		CoreContainer coreContainer = CoreContainer.createAndLoad(solrServer,
				solrXml);
		EmbeddedSolrServer server = new EmbeddedSolrServer(coreContainer,
				"collection1");
		SolrInputDocument doc2 = new SolrInputDocument();
		doc2.addField("id", "id1", 1.0f);
		doc2.addField("name", "doc1", 1.0f);
		doc2.addField("price", 20);
		server.add(doc2);
		UpdateResponse commit = server.commit();
		System.out.println("commit:" + commit);
		SolrQuery solrQuery = new SolrQuery();
		solrQuery.setParam("fl", "id,score");
		solrQuery.setParam("q", "*");
		// solrQuery.setQuery("id:bala");
		QueryResponse rsp = server.query(solrQuery);
		SolrDocumentList docs = rsp.getResults();
		System.out.println(docs);
		server.shutdown();
		return "";
	}
}
