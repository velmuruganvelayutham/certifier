package com.certifier.rest.solr;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.ParserConfigurationException;

import org.apache.solr.client.solrj.embedded.EmbeddedSolrServer;
import org.apache.solr.core.CoreContainer;
import org.xml.sax.SAXException;

public class EmbeddedServer {

	public EmbeddedServer() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) throws ParserConfigurationException,
			IOException, SAXException {
		new EmbeddedServer().start();

	}

	private void start() {
		final String baseTempPath = System.getProperty("java.io.tmpdir");

		File tempDir = new File(baseTempPath + File.separator
				+ System.getProperty("user.name") + File.separator + "solrhome");
		if (System.getProperty("tmpdir.solrhome") != null) {
			// allow for an override of tmpdir
			tempDir = new File(System.getProperty("tmpdir.solrhome"));
		}
		if (!tempDir.exists()) {
			tempDir.mkdirs();
		}

		String solrServer = tempDir.getAbsolutePath();
		File home = new File(solrServer);
		File f = new File(home, "solr.xml");
		CoreContainer coreContainer = new CoreContainer(
				"C:\\Users\\velmuruganv\\Downloads\\Chrome\\solr-4.8.0\\solr-4.8.0\\example\\core-quiz-app\\");
		coreContainer.load();
		// CoreContainer container = CoreContainer.createAndLoad(solrServer, f);
		EmbeddedSolrServer primaryServer = new EmbeddedSolrServer(
				coreContainer, "core0");

		System.out.println("solr started ");
	}

}
