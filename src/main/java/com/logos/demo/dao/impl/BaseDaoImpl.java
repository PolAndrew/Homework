package com.logos.demo.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.transaction.annotation.Transactional;

import com.logos.demo.dao.BaseDao;


public abstract class BaseDaoImpl<E, N extends Number> implements BaseDao<E, N> {

	private Class<E> entityClass;

	public BaseDaoImpl(Class<E> entityClass) {
		
		this.entityClass = entityClass;
		
	}

	@PersistenceContext(name = "logos")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Transactional
	public E findById(N id) {
		try {
			Query query = entityManager.createQuery("from " + entityClass.getSimpleName() + " e where e.id = :id");
			query.setParameter("id", id);
			return (E) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}
	@SuppressWarnings("unchecked")
	@Transactional
	public E findByName(String name) {
		try {
			Query query = entityManager.createQuery("from " + entityClass.getSimpleName() + " e where e.name = :name");
			query.setParameter("name", name);
			return (E) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
	}

	@Transactional
	public void save(E entity) {
		entityManager.persist(entity);
		entityManager.flush();
	}

	@Transactional
	public void remove(E entity) {
		entityManager.remove(entityManager.merge(entity));
	}

	@Transactional
	public E update(E entity) {
		return entityManager.merge(entity);
	}

	@SuppressWarnings("unchecked")
	@Transactional
	public List<E> findAll() {
		return entityManager.createQuery("from " + entityClass.getSimpleName()).getResultList();
	}

}
