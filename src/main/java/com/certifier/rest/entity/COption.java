package com.certifier.rest.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_options database table.
 * 
 */
@Entity
@Table(name="c_options")
@NamedQuery(name="COption.findAll", query="SELECT c FROM COption c")
public class COption implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_options_id", unique=true, nullable=false)
	private int cOptionsId;

	@Column(length=45)
	private String choices;

	private int no;

	//bi-directional many-to-one association to CQuestion
	@ManyToOne
	@JoinColumn(name="c_questions_id", nullable=false)
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

	public int getNo() {
		return this.no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public CQuestion getCQuestion() {
		return this.CQuestion;
	}

	public void setCQuestion(CQuestion CQuestion) {
		this.CQuestion = CQuestion;
	}

}