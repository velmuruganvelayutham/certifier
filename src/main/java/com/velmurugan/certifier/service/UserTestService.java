package com.velmurugan.certifier.service;

import java.util.List;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.entity.UserTest;

public interface UserTestService {

	public List<UserTest> findAll();

	public UserTest find(Long id);

	public UserTest findByUsernameAndTestID(String email,Long testID);

	public List<UserTest> findAll(Page page);

	public void create(UserTest userTest);

	public void update(UserTest userTest);

	public void delete(UserTest userTest);

	public Long count();

}
