package com.bridea.siak.dao;

import java.io.Serializable;
import java.util.List;

import org.bouncycastle.jce.provider.JDKDSASigner.noneDSA;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * Hibernate based implementation for {@link GenericDAO} interface.
 * 
 * @author Wahydin Scatt
 * @param <T>
 */
@Component
public class HibernateGenericDAO<T> implements GenericDAO<T>, Serializable {

	@Autowired
	private SessionFactory factory;
	private Class<T> persistentClass;

	public HibernateGenericDAO() {
	}

	public HibernateGenericDAO(final Class<T> persistentClass) {
		super();
		this.persistentClass = persistentClass;
	}

	@Transactional
	@Override
	public void save(final T entity) {
		getSession().saveOrUpdate(entity);
	}

	private Session getSession() {
		return factory.getCurrentSession();
	}

	@SuppressWarnings("unchecked")
	@Transactional
	@Override
	public T update(final T entity) {
		return (T) getSession().merge(entity);
	}

	@Transactional
	@Override
	public void delete(final T entity) {
		getSession().delete(entity);
	}

	@SuppressWarnings("unchecked")
	@Transactional(readOnly = true)
	@Override
	public List<T> getByCriteria(final Criterion... criterion) {
		final Criteria crit = getSession().createCriteria(persistentClass);
		if (criterion != null) {
			for (final Criterion c : criterion) {
				crit.add(c);
			}
		}
		return crit.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T getByIdINT(final int id) {
		return (T) getSession().get(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T getByIdSTRING(final String id) {
		return (T) getSession().get(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	@Transactional
	public T getByIdLONG(final Long id) {
		return (T) getSession().get(persistentClass, id);
	}
}
