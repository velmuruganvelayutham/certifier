package com.velmurugan.certifier.service;

import java.util.List;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.entity.CQuestion;

public interface QuestionService {

	public List<CQuestion> findAll();

	public CQuestion find(Long id);

	public List<CQuestion> findAll(Page page);

	public void create(CQuestion CQuestion);

	public void update(CQuestion CQuestion);

	public void delete(CQuestion CQuestion);

	public Long count();
}
