package br.com.steventos.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

import br.com.steventos.model.Evento;
import br.com.steventos.model.Pessoa;

public class EventoDAOTest extends DAOTest {

	@Test
	public void testPersist_success() {

		Pessoa pessoa = new Pessoa();
		pessoa.setEmail("brun_dutra@hotmail.com");
		pessoa.setNome("Bruno Dutra");
		pessoa.setDataNascimento(LocalDate.of(1995, 5, 13));

		Evento evento = new Evento();
		evento.setCidade("Niteroi");
		evento.setDataFim(LocalDate.now());
		evento.setDataIni(LocalDate.now());
		evento.setDescricao("Evento 1 - Teste");
		evento.setNome("E1");

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
