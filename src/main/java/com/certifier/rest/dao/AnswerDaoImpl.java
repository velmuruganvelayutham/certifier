package com.certifier.rest.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.certifier.rest.domain.Question;
import com.certifier.rest.entity.CAnswer;
import com.certifier.rest.util.PersistenceUtil;

public class AnswerDaoImpl implements AnswerDao {

	EntityManager em = null;

	public AnswerDaoImpl() {
		em = PersistenceUtil.getEntityManager();
	}

	public CAnswer getById(int id) {

		// TODO Auto-generated method stub
		return null;
	}

	public void add(Question question) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Question qtn = new Question();

	}

	public void update(Question question) {
		// TODO Auto-generated method stub

	}

}
