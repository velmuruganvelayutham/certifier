package com.velmurugan.certifier.dao.impl;

import org.springframework.stereotype.Repository;

import com.velmurugan.certifier.dao.TestDao;
import com.velmurugan.certifier.model.CTest;

@Repository
public class TestDaoImpl extends HibernateGenericDaoImpl<CTest> implements
		TestDao {
	public TestDaoImpl() {
		setClazz(CTest.class);
	}
}
