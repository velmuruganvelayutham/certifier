package com.velmurugan.certifier.service;

import java.util.List;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.model.Vendor;

public interface VendorService {

	public List<Vendor> findAll();

	public Vendor find(Long id);

	public List<Vendor> findAll(Page page);

	public void create(Vendor vendor);

	public void update(Vendor vendor);

	public void delete(Vendor vendor);

	public Long count();
}
