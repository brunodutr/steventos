package br.com.steventos.dao.impl;

import javax.inject.Inject;

import br.com.steventos.dao.AbstractDAO;
import br.com.steventos.model.impl.Evento;

public class EventoDAO extends AbstractDAO<Evento>{

	@Inject
	private LocalDAO localDAO;
	
	public EventoDAO() {
		super(Evento.class);
	}
	
	@Override
	public Evento create(Evento evento) {
		
		evento.setLocal(localDAO.saveOrUpdate(evento.getLocal()));
		
		return super.create(evento);
	}

	
}
