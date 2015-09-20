package com.velmurugan.certifier.entity;

import java.io.Serializable;
import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
	@Column(name = "tests_id", unique = true, nullable = false)
	private Long cTestsId;

	public Long getcTestsId() {
		return cTestsId;
	}

	public void setcTestsId(Long cTestsId) {
		this.cTestsId = cTestsId;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	@Lob
	@Column(nullable = true)
	private byte[] file;

	@Column(nullable = false, length = 45)
	private String name;

	@Column(nullable = true, length = 45, name = "category")
	private String category;

	// bi-directional many-to-one association to CQuestion
	@OneToMany(mappedBy = "CTest", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Set<CQuestion> CQuestions =new LinkedHashSet<CQuestion>();

	public CTest() {
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
		return this.category;
	}

	public void setNo(String no) {
		this.category = no;
	}

	public Set<CQuestion> getCQuestions() {
		return this.CQuestions;
	}

	public void setCQuestions(Set<CQuestion> CQuestions) {
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