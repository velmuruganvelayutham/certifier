package com.tocgroup.tradeshow.dao.impl;

import org.springframework.stereotype.Repository;

import com.tocgroup.tradeshow.dao.SettingsDao;
import com.tocgroup.tradeshow.model.Settings;

@Repository
public class SettingsDaoImpl extends HibernateGenericDaoImpl<Settings>
		implements SettingsDao {

	public SettingsDaoImpl() {
		setClazz(Settings.class);
	}
}
