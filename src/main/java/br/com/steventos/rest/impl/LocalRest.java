package br.com.steventos.rest.impl;

import javax.ws.rs.Path;

import br.com.steventos.dao.impl.LocalDAO;
import br.com.steventos.model.impl.Local;
import br.com.steventos.rest.AbstractRest;

@Path("/locais")
public class LocalRest extends AbstractRest<Local, LocalDAO>{

	
}
