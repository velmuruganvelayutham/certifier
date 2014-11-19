package com.certifier.rest.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.servlet.http.HttpServlet;

import com.certifier.rest.entity.CUser;

public abstract class BaseController extends HttpServlet {

	public BaseController() {
		super();
	}

	protected void createUser(String emilid, String password,
			EntityManager entityManager) {
		entityManager.getTransaction().begin();
		CUser user = new CUser();
		user.setEmailid(emilid);
		user.setPassword(password);
		entityManager.persist(user);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	protected boolean isUserExists(String emilid, EntityManager entityManager) {
		CUser user = getUserByMail(emilid, entityManager);
		if (user != null) {
			System.out.println("User already exists:" + user);
			return true;
		}
		return false;
	}

	protected CUser getUserByMail(String emilid, EntityManager entityManager) {
		Query createQuery = entityManager
				.createQuery("select c from CUser c where c.emailid=:emailid");
		List<CUser> user = createQuery.setParameter("emailid", emilid)
				.getResultList();
		return user.get(0);
	}

}