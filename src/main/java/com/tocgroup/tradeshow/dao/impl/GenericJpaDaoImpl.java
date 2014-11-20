package com.tocgroup.tradeshow.dao.impl;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.tocgroup.tradeshow.dao.GenericDao;

public abstract class GenericJpaDaoImpl<T extends Serializable> implements
		GenericDao<T> {

	private Class<T> clazz;

	@PersistenceContext
	EntityManager entityManager;

	public void setClazz(Class<T> clazzToSet) {
		this.clazz = clazzToSet;
	}

	public T findOne(Long id) {
		return entityManager.find(clazz, id);
	}

	public List<T> findAll() {
		return entityManager.createQuery("from " + clazz.getName())
				.getResultList();
	}

	public void save(T entity) {
		entityManager.persist(entity);
	}

	public T update(T entity) {

		T merge = entityManager.merge(entity);
		return merge;
	}

	public void delete(T entity) {
		entityManager.remove(entity);
	}

	public void deleteById(Long entityId) {
		T entity = findOne(entityId);
		delete(entity);
	}
}