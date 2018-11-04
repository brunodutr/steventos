package br.com.steventos.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Ignore;
import org.junit.Test;

import br.com.steventos.model.impl.Evento;
import br.com.steventos.model.impl.Pessoa;

public class EventoDAOTest extends DAOTest {

	@Ignore
	@Test
	public void testPersist_success() {

		Pessoa pessoa = new Pessoa();
		pessoa.setEmail("brun_dutra@hotmail.com");
		pessoa.setNome("Bruno Dutra");
		
		Evento evento = new Evento();
		
		Set<Pessoa> pessoas = new HashSet<>();
		pessoas.add(pessoa);

		evento.setPessoas(pessoas);

		em.getTransaction().begin();
		em.persist(evento);
		em.getTransaction().commit();

		List<Evento> eventoList = em.createQuery("select e from Evento e", Evento.class).getResultList();
		
		assertNotNull(eventoList);
		assertEquals(1, eventoList.size());
	}
}
