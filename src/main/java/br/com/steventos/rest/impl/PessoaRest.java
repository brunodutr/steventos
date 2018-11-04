package br.com.steventos.rest.impl;

import java.util.Date;

import javax.inject.Inject;
import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.hibernate.Hibernate;

import br.com.steventos.dao.impl.LocalDAO;
import br.com.steventos.dao.impl.PessoaDAO;
import br.com.steventos.model.impl.Evento;
import br.com.steventos.model.impl.Hospedagem;
import br.com.steventos.model.impl.Local;
import br.com.steventos.model.impl.Pessoa;
import br.com.steventos.model.impl.Transporte;
import br.com.steventos.rest.AbstractRest;

@Path("/pessoas")
public class PessoaRest extends AbstractRest<Pessoa, PessoaDAO> {

	@Inject
	private LocalDAO localDAO;

	@GET
	@Path("/add/{id:[0-9][0-9]*}")
	@Transactional
	public void addEvento(@PathParam("id") Long id) {

		Pessoa pessoa = new Pessoa();
		pessoa.setNome("Breno Dutra");
		pessoa.setEmail("breno_dutra@hotmail.com");
		pessoa.setDataNascimento(new Date());

		adicionaEvento(pessoa);
		adicionaHospedagem(pessoa);
		adicionaTransporte(pessoa);

		dao.create(pessoa);
	}

	private void adicionaEvento(Pessoa pessoa) {

		Evento evento = new Evento();
		evento.setNome("Rock in Rio");

		Local local = new Local();
		local.setCidade("Rio de Janeiro");
		local.setEstado("RJ");

		evento.setLocal(localDAO.saveOrUpdate(local));
		evento.setDescricao("3º dia - Rock in Rio");
		evento.setDataIni(new Date());
		evento.setDataFim(new Date());

		Hibernate.initialize(pessoa.getEventos());

		pessoa.getEventos().add(evento);
	}

	private void adicionaHospedagem(Pessoa pessoa) {

		Hospedagem hospedagem = new Hospedagem();
		hospedagem.setNome("Hotel 1");

		Local local = new Local();
		local.setCidade("Rio de Janeiro");
		local.setEstado("RJ");
		
		hospedagem.setLocal(localDAO.saveOrUpdate(local));
		
		Hibernate.initialize(pessoa.getHospedagens());

		pessoa.getHospedagens().add(hospedagem);
	}

	private void adicionaTransporte(Pessoa pessoa) {

		Transporte transporte = new Transporte();
		transporte.setNome("Magé x Candelária");

		Local local = new Local();
		local.setCidade("Rio de Janeiro");
		local.setEstado("RJ");
		
		Local local2 = new Local();
		local2.setCidade("São Paulo");
		local2.setEstado("SP");
		
		transporte.setOrigem(localDAO.saveOrUpdate(local));
		transporte.setDestino(localDAO.saveOrUpdate(local2));
		
		Hibernate.initialize(pessoa.getTransportes());

		pessoa.getTransportes().add(transporte);
	}
}
