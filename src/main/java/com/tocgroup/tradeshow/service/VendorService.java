package com.tocgroup.tradeshow.service;

import java.util.List;

import com.tocgroup.tradeshow.dao.Page;
import com.tocgroup.tradeshow.model.Vendor;

public interface VendorService {

	public List<Vendor> findAll();

	public Vendor find(Long id);

	public List<Vendor> findAll(Page page);

	public void create(Vendor vendor);

	public void update(Vendor vendor);

	public void delete(Vendor vendor);

	public Long count();
}
