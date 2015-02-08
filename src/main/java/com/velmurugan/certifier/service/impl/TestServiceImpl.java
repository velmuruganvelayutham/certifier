package com.velmurugan.certifier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.dao.TestDao;
import com.velmurugan.certifier.model.CTest;
import com.velmurugan.certifier.service.TestService;

@Service
@Transactional
public class TestServiceImpl implements TestService {

	@Autowired
	private TestDao testDao;

	@Override
	public List<CTest> findAll() {
		List<CTest> findAll = testDao.findAll();
		return findAll;
	}

	@Override
	public CTest find(Long id) {
		CTest CTest = testDao.findOne(Long.valueOf(id));
		return CTest;
	}

	@Override
	public void create(CTest CTest) {
		testDao.save(CTest);
	}

	@Override
	public void delete(CTest CTest) {
		testDao.delete(CTest);
	}

	@Override
	public List<CTest> findAll(Page page) {
		return testDao.findAll(page);

	}

	@Override
	public Long count() {

		return testDao.count();
	}

	@Override
	public void update(CTest CTest) {
		testDao.update(CTest);
	}
}
