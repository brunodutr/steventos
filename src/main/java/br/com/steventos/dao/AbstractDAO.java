package br.com.steventos.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

public abstract class AbstractDAO<T> {

	private Class<T> entityClass;

	@PersistenceContext(unitName = "steventos_pu")
	private EntityManager em;

	public AbstractDAO() {

	}

	public AbstractDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	@Transactional
	public T create(T entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}

	@Transactional
	public void update(T entity) {
		em.merge(entity);
	}

	@Transactional
	public void delete(Long id) {
		T entity = em.find(entityClass, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

	@Transactional
	public void delete(T entity) {
		em.remove(entity);
	}

	public T find(Long id) {
		return em.find(entityClass, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		return em.createQuery("select t from " + entityClass.getSimpleName() + " t").getResultList();
	}
}
