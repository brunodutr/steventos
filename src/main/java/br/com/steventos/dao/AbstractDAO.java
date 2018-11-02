package br.com.steventos.dao;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;

@Transactional
public abstract class AbstractDAO<T> {

	private Class<T> entityClass;

	@PersistenceContext(unitName = "steventos_pu")
	private EntityManager em;

	public AbstractDAO() {

	}

	public AbstractDAO(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T create(T entity) {
		em.persist(entity);
		em.flush();
		return entity;
	}

	public void update(T entity) {
		em.merge(entity);
		em.flush();
	}

	public void delete(Long id) {
		T entity = em.find(entityClass, id);
		if (entity != null) {
			em.remove(entity);
		}
	}

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

	public Set<?> getField(Long id, String campo) throws Exception {

		T object = em.getReference(entityClass, id);

		String getterMethod = toGetter(campo);

		Method method = entityClass.getDeclaredMethod(getterMethod, null);

		Hibernate.initialize(method.invoke(object, null));

		return (Set<?>) method.invoke(object, null);

	};

	private String toGetter(String texto) {

		return "get" + texto.toUpperCase().charAt(0) + texto.toLowerCase().substring(1);

	}
}
