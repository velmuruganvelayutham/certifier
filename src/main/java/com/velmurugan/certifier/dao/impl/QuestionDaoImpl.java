package com.velmurugan.certifier.dao.impl;

import org.springframework.stereotype.Repository;

import com.velmurugan.certifier.dao.QuestionDao;
import com.velmurugan.certifier.model.CQuestion;

@Repository
public class QuestionDaoImpl extends HibernateGenericDaoImpl<CQuestion>
		implements QuestionDao {

	public QuestionDaoImpl() {
		setClazz(CQuestion.class);
	}
}
