package com.certifier.rest.util;

import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.Map;

public class SessionStore {

	private Map<Integer, LinkedList<String>> optionMap = null;
	private Map<Integer, LinkedList<String>> answerMap = null;
	private Map<Integer, LinkedList<String>> questionMap = null;

	public SessionStore() {
		optionMap = new LinkedHashMap<Integer, LinkedList<String>>();
		answerMap = new LinkedHashMap<Integer, LinkedList<String>>();
	}

	public void storeOptions(Integer questionNo, LinkedList<String> list) {

		optionMap.put(questionNo, list);
	}

	public void storeAnswers(Integer questionNo, LinkedList<String> list) {

		answerMap.put(questionNo, list);
	}

	public Map<Integer, LinkedList<String>> getOptionMap() {
		return optionMap;
	}

	public void setOptionMap(Map<Integer, LinkedList<String>> optionMap) {
		this.optionMap = optionMap;
	}

	public Map<Integer, LinkedList<String>> getAnswerMap() {
		return answerMap;
	}

	public void setAnswerMap(Map<Integer, LinkedList<String>> answerMap) {
		this.answerMap = answerMap;
	}

}
