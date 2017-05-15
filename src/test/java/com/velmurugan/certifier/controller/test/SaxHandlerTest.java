package com.velmurugan.certifier.controller.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.List;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.junit.Test;

import com.velmurugan.certifier.model.QuestionBean;
import com.velmurugan.certifier.sax.parser.SaxHandler;

import junit.framework.Assert;

public class SaxHandlerTest {

	@Test
	public void parseXml() {
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("xml/test.xml").getFile());

		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			InputStream xmlInput = new FileInputStream(file);
			SAXParser saxParser = factory.newSAXParser();
			SaxHandler handler = new SaxHandler();
			saxParser.parse(xmlInput, handler);

			List<QuestionBean> questions = handler.getTestBean().getQuestions();
			for (QuestionBean questionBean : questions) {
				System.out.println(questionBean);
			}
			Assert.assertEquals(10, questions.size());
		}
		catch (Throwable err) {
			err.printStackTrace();
		}

	}
}
