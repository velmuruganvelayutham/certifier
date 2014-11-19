package com.certifier.rest.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import com.certifier.rest.domain.Question;
import com.certifier.rest.entity.CQuestion;
import com.certifier.rest.util.PersistenceUtil;

public class QuestionDaoImpl implements QuestionDao {

	EntityManager em = null;

	public QuestionDaoImpl() {

	}

	public CQuestion getById(int id) {

		EntityManager entityManager = PersistenceUtil.getEntityManager();
		CQuestion question = entityManager.find(CQuestion.class, id);

		return question;
	}

	public void add(Question question) {
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		Question qtn = new Question();

	}

	public CQuestion getQuestion(int testNo, int pageNumber) {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		// TypedQuery<CQuestion> createQuery = entityManager
		// .createQuery(
		// "from CQuestion q where q.CTest.id=:testNo order by q.questionno asc",
		// CQuestion.class).setParameter("testNo",
		// Integer.valueOf(testNo));
		TypedQuery<CQuestion> createQuery = entityManager.createQuery(
				"from CQuestion", CQuestion.class);
		createQuery.setFirstResult(pageNumber - 1);
		createQuery.setMaxResults(1);

		List<CQuestion> resultList = createQuery.getResultList();
		int size = resultList.size();
		System.out.println("question results:" + resultList + "          size"
				+ size);
		return (size > 0 ? resultList.get(0) : null);
	}

	public int getTotalNoOfQuestions() {

		EntityManager entityManager = PersistenceUtil.getEntityManager();

		return entityManager.createQuery("from CQuestion").getResultList()
				.size();

	}

	public void update(Question question) {
		// TODO Auto-generated method stub

	}

	public static void main(String[] args) {
		new QuestionDaoImpl().getQuestion(11, 2);
	}

	@Override
	public List<CQuestion> list() {
		EntityManager entityManager = PersistenceUtil.getEntityManager();
		TypedQuery<CQuestion> typedQuery = entityManager.createQuery(
				"SELECT c FROM CQuestion c", CQuestion.class);
		return typedQuery.getResultList();
	}
}
