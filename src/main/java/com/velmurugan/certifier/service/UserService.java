package com.velmurugan.certifier.service;

import java.util.List;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.entity.Users;

public interface UserService {

	public List<Users> findAll();

	public Users find(Long id);

	public List<Users> findAll(Page page);

	public void create(Users Users);

	public void update(Users Users);

	public void delete(Users Users);

	public Long count();
}
