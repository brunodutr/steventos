package br.com.steventos.rest.impl;

import java.util.Date;

import javax.enterprise.context.RequestScoped;
import javax.transaction.Transactional;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.hibernate.Hibernate;

import br.com.steventos.dao.impl.PessoaDAO;
import br.com.steventos.model.Evento;
import br.com.steventos.model.Hospedagem;
import br.com.steventos.model.Pessoa;
import br.com.steventos.model.Transporte;
import br.com.steventos.rest.AbstractRest;

@RequestScoped
@Path("/pessoas")
@Produces("application/json")
@Consumes("application/json")
public class PessoaRest extends AbstractRest<Pessoa, PessoaDAO> {

	@GET
	@Path("/add/{id:[0-9][0-9]*}")
	@Transactional
	public void addEvento(@PathParam("id") Long id) {

		Pessoa pessoa = dao.find(id);

		adicionaEvento(pessoa);
		adicionaHospedagem(pessoa);
		adicionaTransporte(pessoa);

		dao.update(pessoa);
	}

	private void adicionaEvento(Pessoa pessoa) {

		Evento evento = new Evento();
		evento.setNome("Hackathon JAVA");
		evento.setCidade("California");
		evento.setDescricao("JAVA!!");
		evento.setDataIni(new Date());
		evento.setDataFim(new Date());

		Hibernate.initialize(pessoa.getEventos());

		pessoa.getEventos().add(evento);
	}

	private void adicionaHospedagem(Pessoa pessoa) {

		Hospedagem hospedagem = new Hospedagem();
		hospedagem.setNome("Hotel 1");

		Hibernate.initialize(pessoa.getHospedagens());

		pessoa.getHospedagens().add(hospedagem);
	}

	private void adicionaTransporte(Pessoa pessoa) {

		Transporte transporte = new Transporte();
		transporte.setNome("Magé x Candelária");

		Hibernate.initialize(pessoa.getTransportes());

		pessoa.getTransportes().add(transporte);
	}
}
