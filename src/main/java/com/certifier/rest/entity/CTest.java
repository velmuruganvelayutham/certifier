package com.certifier.rest.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * The persistent class for the c_tests database table.
 * 
 */
@Entity
@Table(name = "c_tests")
@NamedQuery(name = "CTest.findAll", query = "SELECT c FROM CTest c")
public class CTest implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "c_tests_id", unique = true, nullable = false)
	private int cTestsId;

	@Lob
	@Column(nullable = false)
	private byte[] file;

	@Column(nullable = false, length = 45)
	private String name;

	@Column(nullable = false, length = 45)
	private String no;

	// bi-directional many-to-one association to CQuestion
	@OneToMany(mappedBy = "CTest")
	private List<CQuestion> CQuestions;

	public CTest() {
	}

	public int getCTestsId() {
		return this.cTestsId;
	}

	public void setCTestsId(int cTestsId) {
		this.cTestsId = cTestsId;
	}

	public Object getFile() {
		return this.file;
	}

	public void setFile(byte[] file) {
		this.file = file;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNo() {
		return this.no;
	}

	public void setNo(String no) {
		this.no = no;
	}

	public List<CQuestion> getCQuestions() {
		return this.CQuestions;
	}

	public void setCQuestions(List<CQuestion> CQuestions) {
		this.CQuestions = CQuestions;
	}

	public CQuestion addCQuestion(CQuestion CQuestion) {
		getCQuestions().add(CQuestion);
		CQuestion.setCTest(this);

		return CQuestion;
	}

	public CQuestion removeCQuestion(CQuestion CQuestion) {
		getCQuestions().remove(CQuestion);
		CQuestion.setCTest(null);

		return CQuestion;
	}

}