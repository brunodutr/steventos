package br.com.steventos.rest.impl;

import javax.ws.rs.Path;

import br.com.steventos.dao.impl.EventoDAO;
import br.com.steventos.model.impl.Evento;
import br.com.steventos.rest.AbstractRest;


@Path("/eventos")
public class EventoRest extends AbstractRest<Evento, EventoDAO> {

}
