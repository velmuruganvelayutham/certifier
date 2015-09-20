package com.velmurugan.certifier.model;

import java.util.LinkedList;
import java.util.List;

public class TestBean {

	private String name;

	private String description;

	private String category;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the questions
	 */
	public List<QuestionBean> getQuestions() {
		return questions;
	}

	/**
	 * @param questions the questions to set
	 */
	public void setQuestions(List<QuestionBean> questions) {
		this.questions = questions;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "TestBean [name=" + name + ", description=" + description
				+ ", category=" + category + ", questions=" + questions + "]";
	}

	private List<QuestionBean> questions = new LinkedList<QuestionBean>();
}
