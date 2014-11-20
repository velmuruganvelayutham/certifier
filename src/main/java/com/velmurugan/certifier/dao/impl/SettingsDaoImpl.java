package com.velmurugan.certifier.dao.impl;

import org.springframework.stereotype.Repository;

import com.velmurugan.certifier.dao.SettingsDao;
import com.velmurugan.certifier.model.Settings;

@Repository
public class SettingsDaoImpl extends HibernateGenericDaoImpl<Settings>
		implements SettingsDao {

	public SettingsDaoImpl() {
		setClazz(Settings.class);
	}
}
