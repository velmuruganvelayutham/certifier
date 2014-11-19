package com.certifier.rest.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_answers database table.
 * 
 */
@Entity
@Table(name="c_answers")
@NamedQuery(name="CAnswer.findAll", query="SELECT c FROM CAnswer c")
public class CAnswer implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_answers_id", unique=true, nullable=false)
	private int cAnswersId;

	@Column(length=45)
	private String answer;

	private int no;

	//bi-directional many-to-one association to CQuestion
	@ManyToOne
	@JoinColumn(name="c_questions_id", nullable=false)
	private CQuestion CQuestion;

	public CAnswer() {
	}

	public int getCAnswersId() {
		return this.cAnswersId;
	}

	public void setCAnswersId(int cAnswersId) {
		this.cAnswersId = cAnswersId;
	}

	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
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