package com.velmurugan.certifier.dao.impl;

import org.springframework.stereotype.Repository;

import com.velmurugan.certifier.dao.VerificationTokenDao;
import com.velmurugan.certifier.entity.VerificationToken;

@Repository
public class VerificationTokenDaoImpl extends HibernateGenericDaoImpl<VerificationToken>
		implements VerificationTokenDao {
	public VerificationTokenDaoImpl() {
		setClazz(VerificationToken.class);
	}
}
