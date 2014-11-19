package com.certifier.rest.dao;

import java.util.List;

import com.certifier.rest.domain.Question;
import com.certifier.rest.entity.CQuestion;

public interface QuestionDao {

	public CQuestion getById(int id);

	public void add(Question question);

	public void update(Question question);

	public List<CQuestion> list();

}
