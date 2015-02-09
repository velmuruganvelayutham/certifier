package com.velmurugan.certifier.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 * The persistent class for the c_options database table.
 * 
 */
@Entity
@Table(name = "c_options")
@NamedQuery(name = "COption.findAll", query = "SELECT c FROM COption c")
public class COption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_options_id", unique = true, nullable = false)
	private int cOptionsId;

	@Column(length = 45, name = "choice")
	private String choices;

	@Column(length = 45, name = "explanation")
	private String explanation;

	@Column
	private boolean isCorrect;

	// bi-directional many-to-one association to CQuestion
	@ManyToOne
	@JoinColumn(name = "c_questions_id", nullable = false)
	private CQuestion CQuestion;

	public COption() {
	}

	public int getCOptionsId() {
		return this.cOptionsId;
	}

	public void setCOptionsId(int cOptionsId) {
		this.cOptionsId = cOptionsId;
	}

	public String getChoices() {
		return this.choices;
	}

	public void setChoices(String choices) {
		this.choices = choices;
	}

	public boolean isCorrect() {
		return isCorrect;
	}

	public void setCorrect(boolean isCorrect) {
		this.isCorrect = isCorrect;
	}

	public CQuestion getCQuestion() {
		return this.CQuestion;
	}

	public int getcOptionsId() {
		return cOptionsId;
	}

	public void setcOptionsId(int cOptionsId) {
		this.cOptionsId = cOptionsId;
	}

	public String getExplanation() {
		return explanation;
	}

	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}

	public void setCQuestion(CQuestion CQuestion) {
		this.CQuestion = CQuestion;
	}

}