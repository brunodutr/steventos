package br.com.steventos.dao.impl;

import javax.inject.Inject;

import br.com.steventos.dao.AbstractDAO;
import br.com.steventos.model.impl.Hospedagem;

public class HospedagemDAO extends AbstractDAO<Hospedagem> {

	@Inject
	private LocalDAO localDAO;

	public HospedagemDAO() {
		super(Hospedagem.class);
	}

	@Override
	public Hospedagem create(Hospedagem hospedagem) {

		hospedagem.setLocal(localDAO.saveOrUpdate(hospedagem.getLocal()));

		return super.create(hospedagem);
	}
}
