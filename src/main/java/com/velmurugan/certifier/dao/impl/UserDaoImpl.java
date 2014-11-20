package com.velmurugan.certifier.dao.impl;

import org.springframework.stereotype.Repository;

import com.velmurugan.certifier.dao.UserDao;
import com.velmurugan.certifier.model.User;

@Repository
public class UserDaoImpl extends HibernateGenericDaoImpl<User> implements
		UserDao {
	public UserDaoImpl() {
		setClazz(User.class);
	}
}
