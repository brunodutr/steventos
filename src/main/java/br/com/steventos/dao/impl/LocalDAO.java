package br.com.steventos.dao.impl;

import java.util.List;

import javax.inject.Named;
import javax.persistence.TypedQuery;

import br.com.steventos.dao.AbstractDAO;
import br.com.steventos.model.impl.Local;

@Named
public class LocalDAO extends AbstractDAO<Local> {

	private static final String QUERY_CIDADE_ESTADO = "select l from Local l where l.cidade = :cidade and l.estado = :estado";

	public LocalDAO() {
		super(Local.class);
	}

	public Local saveOrUpdate(Local local) {

		local.setId(findId(local));

		if (local.getId() == null) {
			em.persist(local);
			em.flush();
		}

		return local;
	}

	private Long findId(Local local) {
		TypedQuery<Local> query = em.createQuery(QUERY_CIDADE_ESTADO, Local.class);
		query.setParameter("cidade", local.getCidade());
		query.setParameter("estado", local.getEstado());

		List<Local> resultList = query.getResultList();
		if (!resultList.isEmpty())
			return resultList.get(0).getId();

		return null;
	}

}
