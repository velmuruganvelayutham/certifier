package com.velmurugan.certifier.dao;

import com.velmurugan.certifier.entity.UserTest;

public interface UserTestDao extends GenericDao<UserTest> {

	public UserTest findByUsernameAndTestID(String email, Long testId);

}
