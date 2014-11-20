package com.tocgroup.tradeshow.service;

import java.util.List;

import com.tocgroup.tradeshow.dao.Page;
import com.tocgroup.tradeshow.model.Settings;

public interface SettingsService {

	public List<Settings> findAll();

	public Settings find(Long id);

	public List<Settings> findAll(Page page);

	public void create(Settings settings);

	public void delete(Settings settings);

	public Long count();

	public Settings update(Settings settings);

}
