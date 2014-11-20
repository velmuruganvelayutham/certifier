package com.tocgroup.tradeshow.dao.impl;

import org.springframework.stereotype.Repository;

import com.tocgroup.tradeshow.dao.UserDao;
import com.tocgroup.tradeshow.model.User;

@Repository
public class UserDaoImpl extends HibernateGenericDaoImpl<User> implements
		UserDao {
	public UserDaoImpl() {
		setClazz(User.class);
	}
}
