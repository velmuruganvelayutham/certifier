package com.velmurugan.certifier.dao.impl;

import org.springframework.stereotype.Repository;

import com.velmurugan.certifier.dao.UsersDao;
import com.velmurugan.certifier.entity.Users;

@Repository
public class UsersDaoImpl extends HibernateGenericDaoImpl<Users> implements
		UsersDao {
	public UsersDaoImpl() {
		setClazz(Users.class);
	}
}
