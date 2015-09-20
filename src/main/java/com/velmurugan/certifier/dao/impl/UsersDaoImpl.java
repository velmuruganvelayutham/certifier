package com.velmurugan.certifier.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.velmurugan.certifier.dao.UsersDao;
import com.velmurugan.certifier.entity.Users;

@Repository
public class UsersDaoImpl extends HibernateGenericDaoImpl<Users>
		implements UsersDao {
	public UsersDaoImpl() {
		setClazz(Users.class);
	}

	@SuppressWarnings("rawtypes")
	@Override
	public Users findByEmail(String email) {

		Query q = getCurrentSession()
				.createQuery("from Users as u where u.username = :username");
		q.setString("username", email);
		List result = q.list();
		if (result.size() > 0) {
			return (Users) result.get(0);
		}
		else {
			return null;
		}
	}

}
