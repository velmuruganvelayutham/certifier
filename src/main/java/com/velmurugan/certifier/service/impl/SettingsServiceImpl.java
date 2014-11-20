package com.velmurugan.certifier.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.dao.SettingsDao;
import com.velmurugan.certifier.model.Settings;
import com.velmurugan.certifier.service.SettingsService;

@Service
@Transactional
public class SettingsServiceImpl implements SettingsService {

	@Autowired
	private SettingsDao settingsDao;

	@Override
	public List<Settings> findAll() {
		List<Settings> findAll = settingsDao.findAll();
		return findAll;
	}

	@Override
	public Settings find(Long id) {
		Settings vendor = settingsDao.findOne(Long.valueOf(id));
		return vendor;
	}

	@Override
	public void create(Settings vendor) {
		settingsDao.save(vendor);
	}

	@Override
	public void delete(Settings vendor) {
		settingsDao.delete(vendor);
	}

	@Override
	public List<Settings> findAll(Page page) {
		return settingsDao.findAll(page);

	}

	@Override
	public Long count() {

		return settingsDao.count();
	}

	@Override
	public Settings update(Settings settings) {
		return settingsDao.update(settings);
	}
}
