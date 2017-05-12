package com.velmurugan.certifier.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velmurugan.certifier.dao.VerificationTokenDao;
import com.velmurugan.certifier.entity.VerificationToken;
import com.velmurugan.certifier.service.VerificationTokenService;

@Service
@Transactional
public class VerificationTokenServiceImpl implements VerificationTokenService {

	@Autowired
	VerificationTokenDao verificationDao;

	@Override
	public VerificationToken save(VerificationToken verificationToken) {
		verificationDao.save(verificationToken);
		return verificationToken;
	}

}
