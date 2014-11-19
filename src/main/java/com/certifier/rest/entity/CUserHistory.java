package com.certifier.rest.entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the c_user_history database table.
 * 
 */
@Entity
@Table(name="c_user_history")
@NamedQuery(name="CUserHistory.findAll", query="SELECT c FROM CUserHistory c")
public class CUserHistory implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="c_user_history_id", unique=true, nullable=false)
	private int cUserHistoryId;

	@Column(length=45)
	private String result;

	@Column(length=45)
	private String testname;

	@Temporal(TemporalType.TIMESTAMP)
	private Date timetaken;

	//bi-directional many-to-one association to CUser
	@ManyToOne
	@JoinColumn(name="c_user_id", nullable=false)
	private CUser CUser;

	//bi-directional many-to-one association to CUserHistoryDetail
	@OneToMany(mappedBy="CUserHistory")
	private List<CUserHistoryDetail> CUserHistoryDetails;

	public CUserHistory() {
	}

	public int getCUserHistoryId() {
		return this.cUserHistoryId;
	}

	public void setCUserHistoryId(int cUserHistoryId) {
		this.cUserHistoryId = cUserHistoryId;
	}

	public String getResult() {
		return this.result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	public String getTestname() {
		return this.testname;
	}

	public void setTestname(String testname) {
		this.testname = testname;
	}

	public Date getTimetaken() {
		return this.timetaken;
	}

	public void setTimetaken(Date timetaken) {
		this.timetaken = timetaken;
	}

	public CUser getCUser() {
		return this.CUser;
	}

	public void setCUser(CUser CUser) {
		this.CUser = CUser;
	}

	public List<CUserHistoryDetail> getCUserHistoryDetails() {
		return this.CUserHistoryDetails;
	}

	public void setCUserHistoryDetails(List<CUserHistoryDetail> CUserHistoryDetails) {
		this.CUserHistoryDetails = CUserHistoryDetails;
	}

	public CUserHistoryDetail addCUserHistoryDetail(CUserHistoryDetail CUserHistoryDetail) {
		getCUserHistoryDetails().add(CUserHistoryDetail);
		CUserHistoryDetail.setCUserHistory(this);

		return CUserHistoryDetail;
	}

	public CUserHistoryDetail removeCUserHistoryDetail(CUserHistoryDetail CUserHistoryDetail) {
		getCUserHistoryDetails().remove(CUserHistoryDetail);
		CUserHistoryDetail.setCUserHistory(null);

		return CUserHistoryDetail;
	}

}