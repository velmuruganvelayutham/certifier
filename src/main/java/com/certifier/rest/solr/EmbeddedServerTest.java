package com.certifier.rest.solr;

import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.core.CoreContainer;

public class EmbeddedServerTest {

	public static void main(String[] args) {
		CoreContainer coreContainer = new CoreContainer(
				"C:\\Users\\velmuruganv\\Downloads\\Chrome\\solr-4.8.0\\solr-4.8.0\\example\\core-quiz-app\\");
		coreContainer.load();
		// CoreContainer container = CoreContainer.createAndLoad(solrServer, f);
		EmbeddedSolrServer primaryServer = new EmbeddedSolrServer(
				coreContainer, "core0");
	}
}