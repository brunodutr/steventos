package br.com.steventos.dao;

import java.lang.reflect.Method;
import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import org.hibernate.Hibernate;

import br.com.steventos.dto.AutocompleteDTO;
import br.com.steventos.model.BaseModel;
import br.com.steventos.security.AuthorizationRole;
import br.com.steventos.utils.StringUtils;

@Transactional
public abstract class AbstractDAO<T> {

	private static final String QUERY_AUTOCOMPLETE = "select * from %s where %s ilike :texto";

	private Class<T> entityClass;

	@PersistenceContext(unitName = "steventos_pu")
	protected EntityManager em;

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

	public Collection<?> getField(Long id, String campo) throws Exception {
		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<T> query = cb.createQuery(entityClass);
		
		Root<T> root = query.from(entityClass);
		
		root.join(campo, JoinType.INNER);
		
		query.select(root.get(campo));
		
		query.where(cb.equal(root.get("id"), id));
		
		return (Collection<?>) em.createQuery(query).getResultList();

	};

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public void setField(Long id, String campo, BaseModel map) throws Exception {

		T object = em.getReference(entityClass, id);

		//Object newObject = CastUtils.mapToPojo(campo, map);

		String getterMethod = StringUtils.toGetter(campo);

		Method method = entityClass.getDeclaredMethod(getterMethod);

		Hibernate.initialize(method.invoke(object));

		Set objects = (Set<?>) method.invoke(object);

		//objects.add(newObject);

		update(object);

	};

	@SuppressWarnings("unchecked")
	public List<T> findAutocomplete(AutocompleteDTO dto) {
		String queryString = String.format(QUERY_AUTOCOMPLETE, entityClass.getSimpleName(), dto.getCampo());
		Query nativeQuery = em.createNativeQuery(queryString, entityClass);

		nativeQuery.setParameter("texto", dto.getTexto() + "%");

		return nativeQuery.getResultList();
	}
}
