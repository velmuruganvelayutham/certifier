package com.velmurugan.certifier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.dao.QuestionDao;
import com.velmurugan.certifier.entity.CQuestion;
import com.velmurugan.certifier.service.QuestionService;

@Service
@Transactional
public class QuestionServiceImpl implements QuestionService {

	@Autowired
	private QuestionDao cQuestionDao;

	@Override
	public List<CQuestion> findAll() {
		List<CQuestion> findAll = cQuestionDao.findAll();
		return findAll;
	}

	@Override
	public CQuestion find(Long id) {
		CQuestion CQuestion = cQuestionDao.findOne(Long.valueOf(id));
		return CQuestion;
	}

	@Override
	public void create(CQuestion CQuestion) {
		cQuestionDao.save(CQuestion);
	}

	@Override
	public void delete(CQuestion CQuestion) {
		cQuestionDao.delete(CQuestion);
	}

	@Override
	public List<CQuestion> findAll(Page page) {
		return cQuestionDao.findAll(page);

	}

	@Override
	public Long count() {

		return cQuestionDao.count();
	}

	@Override
	public void update(CQuestion CQuestion) {
		cQuestionDao.update(CQuestion);
	}
}
