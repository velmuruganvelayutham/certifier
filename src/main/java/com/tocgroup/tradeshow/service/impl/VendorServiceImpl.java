package com.tocgroup.tradeshow.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tocgroup.tradeshow.dao.Page;
import com.tocgroup.tradeshow.dao.VendorDao;
import com.tocgroup.tradeshow.model.Vendor;
import com.tocgroup.tradeshow.service.VendorService;

@Service
@Transactional
public class VendorServiceImpl implements VendorService {

	@Autowired
	private VendorDao vendorDao;

	@Override
	public List<Vendor> findAll() {
		List<Vendor> findAll = vendorDao.findAll();
		return findAll;
	}

	@Override
	public Vendor find(Long id) {
		Vendor vendor = vendorDao.findOne(Long.valueOf(id));
		return vendor;
	}

	@Override
	public void create(Vendor vendor) {
		vendorDao.save(vendor);
	}

	@Override
	public void delete(Vendor vendor) {
		vendorDao.delete(vendor);
	}

	@Override
	public List<Vendor> findAll(Page page) {
		return vendorDao.findAll(page);

	}

	@Override
	public Long count() {

		return vendorDao.count();
	}

	@Override
	public void update(Vendor vendor) {
		vendorDao.update(vendor);
	}
}
