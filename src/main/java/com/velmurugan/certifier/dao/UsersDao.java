package com.velmurugan.certifier.dao;

import com.velmurugan.certifier.entity.Users;

public interface UsersDao extends GenericDao<Users> {

	
	public Users findByEmail(String email);
}
