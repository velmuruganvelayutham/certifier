package com.velmurugan.certifier.model;

import java.util.LinkedList;
import java.util.List;

public class QuestionBean {

	
	private String title;
	private Boolean isMultiOption;
	private String explanation;
	private List<OptionBean> options= new LinkedList<OptionBean>();
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the isMultiOption
	 */
	public Boolean getIsMultiOption() {
		return isMultiOption;
	}
	/**
	 * @param isMultiOption the isMultiOption to set
	 */
	public void setIsMultiOption(Boolean isMultiOption) {
		this.isMultiOption = isMultiOption;
	}
	/**
	 * @return the explanation
	 */
	public String getExplanation() {
		return explanation;
	}
	/**
	 * @param explanation the explanation to set
	 */
	public void setExplanation(String explanation) {
		this.explanation = explanation;
	}
	/**
	 * @return the options
	 */
	public List<OptionBean> getOptions() {
		return options;
	}
	/**
	 * @param options the options to set
	 */
	public void setOptions(List<OptionBean> options) {
		this.options = options;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Question [title=" + title + ", isMultiOption=" + isMultiOption + ", explanation=" + explanation
				+ ", options=" + options + "]";
	}
}
