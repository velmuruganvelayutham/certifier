package com.velmurugan.certifier.sax.parser;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import com.velmurugan.certifier.model.OptionBean;
import com.velmurugan.certifier.model.QuestionBean;
import com.velmurugan.certifier.model.TestBean;

import junit.framework.Assert;

public class SaxHandler extends DefaultHandler {

	private TestBean testBean;

	private QuestionBean questionBean;

	private List<QuestionBean> questionList = new LinkedList<QuestionBean>();

	private List<OptionBean> optionList = new LinkedList<OptionBean>();

	private OptionBean optionBean;

	private StringBuilder tempValue = new StringBuilder();

	private Stack<String> elementStack = new Stack<String>();

	/**
	 * @return the testBean
	 */
	public TestBean getTestBean() {
		return testBean;
	}

	/**
	 * @param testBean the testBean to set
	 */
	public void setTestBean(TestBean testBean) {
		this.testBean = testBean;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#startElement(java.lang.String,
	 * java.lang.String, java.lang.String, org.xml.sax.Attributes)
	 */
	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attributes) throws SAXException {

		tempValue.setLength(0);
		elementStack.push(qName);
		if ("test".equals(qName)) {
			testBean = new TestBean();
		}
		if ("question".equals(qName)) {
			questionBean = new QuestionBean();
		}
		if ("option".equals(qName)) {
			optionBean = new OptionBean();
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#endElement(java.lang.String,
	 * java.lang.String, java.lang.String)
	 */
	@Override
	public void endElement(String uri, String localName, String qName)
			throws SAXException {

		String tag = elementStack.peek();
		String parentTag = null;
		if (!qName.equals(tag)) {
			throw new InternalError();
		}
		elementStack.pop();
		if (!elementStack.isEmpty())
			parentTag = elementStack.peek();

		if ("name".equals(qName)) {
			testBean.setName(tempValue.toString());
		}
		if ("description".equals(qName)) {
			testBean.setDescription(tempValue.toString());
		}
		if ("title".equals(qName) && "question".equals(parentTag)) {
			questionBean.setTitle(tempValue.toString());
		}
		if ("ismultioption".equals(qName)) {
			questionBean
					.setIsMultiOption(Boolean.valueOf(tempValue.toString()));
		}
		if ("explanation".equals(qName)) {
			questionBean.setExplanation(tempValue.toString());
		}
		if ("question".equals(qName)) {
			questionList.add(questionBean);
		}
		if ("title".equals(qName) && "option".equals(parentTag)) {
			optionBean.setTitle(tempValue.toString());
		}
		if ("isCorrect".equals(qName) && "option".equals(parentTag)) {
			optionBean.setIsCorrect(Boolean.valueOf(tempValue.toString()));
		}
		if ("option".equals(qName)) {
			questionBean.getOptions().add(optionBean);
			optionList.add(optionBean);
		}
		if ("test".equals(qName)) {
			testBean.setQuestions(questionList);
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.xml.sax.helpers.DefaultHandler#characters(char[], int, int)
	 */
	@Override
	public void characters(char[] ch, int start, int length)
			throws SAXException {
		tempValue.append(ch, start, length);
	}

	public void parse(InputStream xmlInputStream) {

		SAXParserFactory factory = SAXParserFactory.newInstance();
		try {
			SAXParser saxParser = factory.newSAXParser();
			saxParser.parse(xmlInputStream, this);

			List<QuestionBean> questions = this.getTestBean().getQuestions();
			for (QuestionBean questionBean : questions) {
				System.out.println(questionBean);
			}
		}
		catch (Throwable err) {
			err.printStackTrace();
		}

	}

}
