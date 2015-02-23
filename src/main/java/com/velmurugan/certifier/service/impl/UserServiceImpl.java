package com.velmurugan.certifier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.dao.UsersDao;
import com.velmurugan.certifier.entity.Users;
import com.velmurugan.certifier.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UsersDao userDao;

	@Override
	public List<Users> findAll() {
		List<Users> findAll = userDao.findAll();
		return findAll;
	}

	@Override
	public Users find(Long id) {
		Users Users = userDao.findOne(Long.valueOf(id));
		return Users;
	}

	@Override
	public void create(Users Users) {
		userDao.save(Users);
	}

	@Override
	public void delete(Users Users) {
		userDao.delete(Users);
	}

	@Override
	public List<Users> findAll(Page page) {
		return userDao.findAll(page);

	}

	@Override
	public Long count() {

		return userDao.count();
	}

	@Override
	public void update(Users Users) {
		userDao.update(Users);
	}

	@Override
	public Users findByEmail(String email) {
		return userDao.findByEmail(email);
	}
}
