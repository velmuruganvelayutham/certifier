package com.certifier.rest.dao;

import com.certifier.rest.domain.Question;
import com.certifier.rest.entity.CAnswer;

public interface AnswerDao {

	public CAnswer getById(int id);

	public void add(Question question);

	public void update(Question question);

}
