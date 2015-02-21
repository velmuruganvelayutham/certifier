package com.velmurugan.certifier.service;

import java.util.List;

import com.velmurugan.certifier.dao.Page;
import com.velmurugan.certifier.entity.Settings;

public interface SettingsService {

	public List<Settings> findAll();

	public Settings find(Long id);

	public List<Settings> findAll(Page page);

	public void create(Settings settings);

	public void delete(Settings settings);

	public Long count();

	public Settings update(Settings settings);

}
