package com.certifier.rest.entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the c_user_history_details database table.
 * 
 */
@Entity
@Table(name="c_user_history_details")
@NamedQuery(name="CUserHistoryDetail.findAll", query="SELECT c FROM CUserHistoryDetail c")
public class CUserHistoryDetail implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_user_history_details_id", unique=true, nullable=false)
	private int cUserHistoryDetailsId;

	@Column(length=45)
	private String attemptedanswer;

	@Column(name="c_answers", nullable=false)
	private int cAnswers;

	@Column(length=45)
	private String category;

	@Column(length=45)
	private String comments;

	@Column(length=45)
	private String percentage;

	@Column(length=45)
	private String question;

	//bi-directional many-to-one association to CUserHistory
	@ManyToOne
	@JoinColumn(name="c_user_history_id", nullable=false)
	private CUserHistory CUserHistory;

	public CUserHistoryDetail() {
	}

	public int getCUserHistoryDetailsId() {
		return this.cUserHistoryDetailsId;
	}

	public void setCUserHistoryDetailsId(int cUserHistoryDetailsId) {
		this.cUserHistoryDetailsId = cUserHistoryDetailsId;
	}

	public String getAttemptedanswer() {
		return this.attemptedanswer;
	}

	public void setAttemptedanswer(String attemptedanswer) {
		this.attemptedanswer = attemptedanswer;
	}

	public int getCAnswers() {
		return this.cAnswers;
	}

	public void setCAnswers(int cAnswers) {
		this.cAnswers = cAnswers;
	}

	public String getCategory() {
		return this.category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getComments() {
		return this.comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getPercentage() {
		return this.percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
	}

	public String getQuestion() {
		return this.question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public CUserHistory getCUserHistory() {
		return this.CUserHistory;
	}

	public void setCUserHistory(CUserHistory CUserHistory) {
		this.CUserHistory = CUserHistory;
	}

}