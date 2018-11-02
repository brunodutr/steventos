package br.com.steventos.rest.impl;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.steventos.dao.impl.TransporteDAO;
import br.com.steventos.model.Transporte;
import br.com.steventos.rest.AbstractRest;

@RequestScoped
@Path("/transportes")
@Produces("application/json")
@Consumes("application/json")
public class TransporteRest extends AbstractRest<Transporte, TransporteDAO> {

}
