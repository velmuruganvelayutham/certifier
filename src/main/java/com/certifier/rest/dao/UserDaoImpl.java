package com.certifier.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.certifier.rest.entity.CUser;
import com.certifier.rest.util.PersistenceUtil;

public class UserDaoImpl implements UserDao {

	public UserDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	public CUser getById(int id) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		CUser user = entityManager.find(CUser.class, id);
		return user;
	}

	public void update(CUser user) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.merge(user);
		entityManager.flush();
		transaction.commit();
	}

	public void add(CUser user) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		entityManager.persist(user);
		entityManager.flush();
		transaction.commit();
	}

	@SuppressWarnings("unchecked")
	public List<CUser> getAllUser() {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		List<CUser> resultList = entityManager.createQuery(
				"SELECT p FROM CUser p").getResultList();
		return resultList;

	}

	public void delete(int id) {

		EntityManager entityManager = PersistenceUtil.getEntityManager();
		EntityTransaction transaction = entityManager.getTransaction();
		transaction.begin();
		CUser user = entityManager.find(CUser.class, id);
		entityManager.remove(user);
		entityManager.flush();
		transaction.commit();
	}
}
