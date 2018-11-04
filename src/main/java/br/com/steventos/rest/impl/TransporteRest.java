package br.com.steventos.rest.impl;

import javax.ws.rs.Path;

import br.com.steventos.dao.impl.TransporteDAO;
import br.com.steventos.model.impl.Transporte;
import br.com.steventos.rest.AbstractRest;

@Path("/transportes")
public class TransporteRest extends AbstractRest<Transporte, TransporteDAO> {

}
