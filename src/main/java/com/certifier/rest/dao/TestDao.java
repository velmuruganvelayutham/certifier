package com.certifier.rest.dao;

import com.certifier.rest.entity.CTest;

public interface TestDao {

	public CTest getById(int id);

	public void add(CTest question);

	// public void update(Question question);

}
