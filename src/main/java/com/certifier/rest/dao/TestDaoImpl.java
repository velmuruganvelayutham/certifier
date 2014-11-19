package com.certifier.rest.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.certifier.rest.domain.Question;
import com.certifier.rest.entity.CTest;
import com.certifier.rest.util.PersistenceUtil;

public class TestDaoImpl implements TestDao {

	EntityManager em = null;

	public TestDaoImpl() {
	}

	public CTest getById(int id) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		CTest test = entityManager.find(CTest.class, id);
		return test;
	}

	public void add(CTest test) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(test);
		entityManager.flush();
		transaction.commit();
	}

	public void update(Question question) {
		// TODO Auto-generated method stub

	}

}
