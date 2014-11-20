package com.tocgroup.tradeshow.dao.impl;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.tocgroup.tradeshow.dao.GenericDao;
import com.tocgroup.tradeshow.dao.Page;

@SuppressWarnings("unchecked")
public abstract class HibernateGenericDaoImpl<T extends Serializable>
		implements GenericDao<T> {
	private Class<T> clazz;

	@Autowired
	private SessionFactory sessionFactory;

	// API

	protected final void setClazz(final Class<T> clazzToSet) {
		clazz = clazzToSet;
	}

	@Override
	public final T findOne(final Long id) {
		return ((T) getCurrentSession().get(clazz, id));
	}

	@Override
	public final List<T> findAll() {
		return getCurrentSession().createQuery("from " + clazz.getName())
				.list();
	}

	@Override
	public final void save(final T entity) {
		getCurrentSession().persist(entity);
	}

	@Override
	public final T update(final T entity) {
		return (T) getCurrentSession().merge(entity);
	}

	@Override
	public final void delete(final T entity) {
		getCurrentSession().delete(entity);
	}

	protected final Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	@Override
	public List<T> findAll(Page page) {
		return getCurrentSession().createQuery("from " + clazz.getName())
				.setMaxResults(page.getPageSize())
				.setFirstResult(page.getPageNo()).list();

	}

	@Override
	public Long count() {
		Query createQuery = getCurrentSession().createQuery(
				"select count(*) from " + clazz.getName());
		Object uniqueResult = createQuery.uniqueResult();
		return ((Long) uniqueResult)
				.longValue();
	}
}