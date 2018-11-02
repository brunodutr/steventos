package br.com.steventos.rest.impl;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import br.com.steventos.dao.impl.HospedagemDAO;
import br.com.steventos.model.Hospedagem;
import br.com.steventos.rest.AbstractRest;

@RequestScoped
@Path("/hospedagens")
@Produces("application/json")
@Consumes("application/json")
public class HospedagemRest extends AbstractRest<Hospedagem, HospedagemDAO> {

}
