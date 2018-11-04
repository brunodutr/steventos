package br.com.steventos.dao.impl;

import br.com.steventos.dao.AbstractDAO;
import br.com.steventos.model.impl.Pessoa;

public class PessoaDAO extends AbstractDAO<Pessoa> {

	public PessoaDAO() {
		super(Pessoa.class);
	}
	
}

