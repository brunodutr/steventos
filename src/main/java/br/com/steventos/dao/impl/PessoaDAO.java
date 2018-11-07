package br.com.steventos.dao.impl;

import javax.persistence.NoResultException;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import br.com.steventos.dao.AbstractDAO;
import br.com.steventos.model.impl.Pessoa;
import br.com.steventos.security.Role;

public class PessoaDAO extends AbstractDAO<Pessoa> {

	public PessoaDAO() {
		super(Pessoa.class);
	}

	public Pessoa findByEmailAndRole(String email, Role permissao) throws NoResultException {

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Pessoa> query = cb.createQuery(Pessoa.class);

		Root<Pessoa> root = query.from(Pessoa.class);

		query.where(cb.equal(root.get("email"), email));
		query.where(cb.equal(root.get("role"), permissao.getCodigo()));

		return em.createQuery(query).getSingleResult();
	}

	public Pessoa findByEmail(String email) throws NoResultException {

		CriteriaBuilder cb = em.getCriteriaBuilder();

		CriteriaQuery<Pessoa> query = cb.createQuery(Pessoa.class);

		Root<Pessoa> root = query.from(Pessoa.class);

		query.where(cb.equal(root.get("email"), email));

		return em.createQuery(query).getSingleResult();
	}
}
