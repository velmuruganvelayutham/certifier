package com.velmurugan.certifier.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.velmurugan.certifier.dao.UserTestDao;
import com.velmurugan.certifier.entity.UserTest;

@Repository
public class UserTestDaoImpl extends HibernateGenericDaoImpl<UserTest> implements UserTestDao {
	private static final Logger logger = LoggerFactory.getLogger(UserTestDaoImpl.class);

	public UserTestDaoImpl() {
		setClazz(UserTest.class);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public UserTest findByUsernameAndTestID(String email, Long testId) {

		Query q = getCurrentSession()
				.createQuery("from UserTest as ut where ut.username = :username and ut.test = :test");
		q.setString("username", email);
		q.setLong("test", testId);
		List result = q.list();
		if (result.size() > 0) {
			logger.info("UserTest is found for email  {} and testId ", email, testId);
			return (UserTest) result.get(0);
		} else {
			return null;
		}
	}

}
