package com.velmurugan.certifier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.dao.UserTestDao;
import com.velmurugan.certifier.entity.UserTest;
import com.velmurugan.certifier.service.UserTestService;

@Service
@Transactional
public class UserTestServiceImpl implements UserTestService {

	@Autowired
	private UserTestDao userTestDao;

	@Override
	public List<UserTest> findAll() {
		List<UserTest> findAll = userTestDao.findAll();
		return findAll;
	}

	@Override
	public UserTest find(Long id) {
		UserTest Users = userTestDao.findOne(Long.valueOf(id));
		return Users;
	}

	@Override
	public void create(UserTest Users) {
		try {
			userTestDao.save(Users);
		} catch (Exception e) {

		}

	}

	@Override
	public void delete(UserTest Users) {
		userTestDao.delete(Users);
	}

	@Override
	public List<UserTest> findAll(Page page) {
		return userTestDao.findAll(page);

	}

	@Override
	public Long count() {

		return userTestDao.count();
	}

	@Override
	public void update(UserTest Users) {
		userTestDao.update(Users);
	}

	@Override
	public UserTest findByUsernameAndTestID(String email, Long testId) {
		return userTestDao.findByUsernameAndTestID(email, testId);
	}

}
