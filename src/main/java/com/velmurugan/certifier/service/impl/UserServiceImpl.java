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
	private UsersDao UsersDao;

	@Override
	public List<Users> findAll() {
		List<Users> findAll = UsersDao.findAll();
		return findAll;
	}

	@Override
	public Users find(Long id) {
		Users Users = UsersDao.findOne(Long.valueOf(id));
		return Users;
	}

	@Override
	public void create(Users Users) {
		UsersDao.save(Users);
	}

	@Override
	public void delete(Users Users) {
		UsersDao.delete(Users);
	}

	@Override
	public List<Users> findAll(Page page) {
		return UsersDao.findAll(page);

	}

	@Override
	public Long count() {

		return UsersDao.count();
	}

	@Override
	public void update(Users Users) {
		UsersDao.update(Users);
	}
}
