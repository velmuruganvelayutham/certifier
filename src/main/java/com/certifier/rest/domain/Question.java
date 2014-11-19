package com.certifier.rest.domain;

import java.util.LinkedList;
import java.util.List;

public class Question {

	public List<Answer> getAnswerList() {
		return answerList;
	}

	public void setAnswerList(List<Answer> answerList) {
		this.answerList = answerList;
	}

	public List<Option> getOptionList() {
		return optionList;
	}

	public void setOptionList(List<Option> optionList) {
		this.optionList = optionList;
	}

	public String getNextQuestionNo() {
		return nextQuestionNo;
	}

	public void setNextQuestionNo(String nextQuestionNo) {
		this.nextQuestionNo = nextQuestionNo;
	}

	public String getNextPreviousNo() {
		return nextPreviousNo;
	}

	public void setNextPreviousNo(String nextPreviousNo) {
		this.nextPreviousNo = nextPreviousNo;
	}

	private String questionNo;
	private String question;
	private List<Answer> answerList = new LinkedList<Answer>();
	private List<Option> optionList = new LinkedList<Option>();
	private String nextQuestionNo;
	private String nextPreviousNo;

	public Question() {
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionNo() {
		return questionNo;
	}

	public void setQuestionNo(String questionNo) {
		this.questionNo = questionNo;
	}

}
