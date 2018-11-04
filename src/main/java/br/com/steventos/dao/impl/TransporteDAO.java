package br.com.steventos.dao.impl;

import javax.inject.Inject;

import br.com.steventos.dao.AbstractDAO;
import br.com.steventos.model.impl.Transporte;

public class TransporteDAO extends AbstractDAO<Transporte> {
	
	@Inject
	private LocalDAO localDAO;

	public TransporteDAO() {
		super(Transporte.class);
	}

	@Override
	public Transporte create(Transporte transporte) {

		transporte.setOrigem(localDAO.saveOrUpdate(transporte.getOrigem()));
		transporte.setDestino(localDAO.saveOrUpdate(transporte.getDestino()));

		return super.create(transporte);
	}

}
