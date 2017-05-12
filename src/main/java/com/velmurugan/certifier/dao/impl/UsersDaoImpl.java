package com.velmurugan.certifier.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.velmurugan.certifier.dao.UsersDao;
import com.velmurugan.certifier.entity.Users;
import com.velmurugan.certifier.entity.VerificationToken;

@Repository
public class UsersDaoImpl extends HibernateGenericDaoImpl<Users> implements UsersDao {
	private static final Logger logger = LoggerFactory.getLogger(UsersDaoImpl.class);

	public UsersDaoImpl() {
		setClazz(Users.class);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Users findByEmail(String email) {

		Query q = getCurrentSession().createQuery("from Users as u where u.username = :username");
		q.setString("username", email);
		List result = q.list();
		if (result.size() > 0) {
			logger.info("User is available for email  {}", email);
			return (Users) result.get(0);
		} else {
			return null;
		}
	}

	@Override
	public Users getUsersByToken(String token) {

		Query q = getCurrentSession().createQuery("from VerificationToken as vt where vt.token = :token");
		q.setString("token", token);
		List result = q.list();

		if (result.size() > 0) {
			logger.info("verification token is found for token {}", token);
			VerificationToken verificationToken = (VerificationToken) result.get(0);
			Users user = verificationToken.getUsers();
			return user;
		} else {
			return null;
		}
	}

}
