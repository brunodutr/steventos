package br.com.steventos.rest.impl;

import javax.ws.rs.Path;

import br.com.steventos.dao.impl.HospedagemDAO;
import br.com.steventos.model.impl.Hospedagem;
import br.com.steventos.rest.AbstractRest;

@Path("/hospedagens")
public class HospedagemRest extends AbstractRest<Hospedagem, HospedagemDAO> {

}
