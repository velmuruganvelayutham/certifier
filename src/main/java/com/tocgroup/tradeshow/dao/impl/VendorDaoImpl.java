package com.tocgroup.tradeshow.dao.impl;

import org.springframework.stereotype.Repository;

import com.tocgroup.tradeshow.dao.VendorDao;
import com.tocgroup.tradeshow.model.Vendor;

@Repository
public class VendorDaoImpl extends HibernateGenericDaoImpl<Vendor> implements
		VendorDao {

	public VendorDaoImpl() {
		setClazz(Vendor.class);
	}
}
