package com.certifier.rest.dao;

import java.util.List;

import com.certifier.rest.entity.CUser;

public interface UserDao {
	public CUser getById(int id);

	public void add(CUser user);

	public void update(CUser user);

	public List<CUser> getAllUser();

	public void delete(int id);
}
