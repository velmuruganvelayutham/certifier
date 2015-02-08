package com.velmurugan.certifier.service;

import java.util.List;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.model.CTest;

public interface TestService {

	public List<CTest> findAll();

	public CTest find(Long id);

	public List<CTest> findAll(Page page);

	public void create(CTest CTest);

	public void update(CTest CTest);

	public void delete(CTest CTest);

	public Long count();
}
