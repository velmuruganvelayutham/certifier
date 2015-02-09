package com.velmurugan.certifier.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the c_questions database table.
 * 
 */
@Entity
@Table(name = "c_questions")
@NamedQuery(name = "CQuestion.findAll", query = "SELECT c FROM CQuestion c")
public class CQuestion implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_questions_id", unique = true, nullable = false)
	private int cQuestionsId;

	@Column(length = 45)
	private String category;

	@Column(nullable = false, length = 1000)
	private String question;

	@Column(length = 45)
	private String questionno;

	// bi-directional many-to-one association to COption
	@OneToMany(mappedBy = "CQuestion")
	private List<COption> COptions;

	// bi-directional many-to-one association to CTest
	@ManyToOne
	@JoinColumn(name = "c_tests_id", nullable = false)
	private CTest CTest;

	public CQuestion() {
	}

	public int getCQuestionsId() {
		return this.cQuestionsId;
	}

	public void setCQuestionsId(int cQuestionsId) {
		this.cQuestionsId = cQuestionsId;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getQuestionno() {
		return this.questionno;
	}

	public void setQuestionno(String questionno) {
		this.questionno = questionno;
	}

	public List<COption> getCOptions() {
		return this.COptions;
	}

	public void setCOptions(List<COption> COptions) {
		this.COptions = COptions;
	}

	public COption addCOption(COption COption) {
		getCOptions().add(COption);
		COption.setCQuestion(this);

		return COption;
	}

	public COption removeCOption(COption COption) {
		getCOptions().remove(COption);
		COption.setCQuestion(null);

		return COption;
	}

	public CTest getCTest() {
		return this.CTest;
	}

	public void setCTest(CTest CTest) {
		this.CTest = CTest;
	}

}