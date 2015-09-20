package com.velmurugan.certifier.dao.impl;

import org.springframework.stereotype.Repository;

import com.velmurugan.certifier.dao.VendorDao;
import com.velmurugan.certifier.entity.Vendor;

@Repository
public class VendorDaoImpl extends HibernateGenericDaoImpl<Vendor>
		implements VendorDao {

	public VendorDaoImpl() {
		setClazz(Vendor.class);
	}
}
