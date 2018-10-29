package br.com.steventos.rest.impl;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.steventos.dao.impl.EventoDAO;
import br.com.steventos.model.Evento;
import br.com.steventos.rest.AbstractRest;

@RequestScoped
@Path("/eventos")
@Produces("application/json")
@Consumes("application/json")
public class EventoRest extends AbstractRest<Evento, EventoDAO> {

}
