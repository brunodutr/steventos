package br.com.steventos.dao;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.h2.tools.RunScript;
import org.hibernate.Session;
import org.hibernate.jdbc.Work;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import br.com.steventos.model.Evento;
import br.com.steventos.model.Pessoa;

public class DAOTest {

	protected static EntityManagerFactory emf;
	protected static EntityManager em;

	@BeforeClass
	public static void init() throws FileNotFoundException, SQLException {
		emf = Persistence.createEntityManagerFactory("steventos_pu_test");
		em = emf.createEntityManager();
	}

	@Before
	public void initializeDatabase() {
		Session session = em.unwrap(Session.class);
		session.doWork(new Work() {
			@Override
			public void execute(Connection connection) throws SQLException {
				try {
					File script = new File(getClass().getResource("/data.sql").getFile());
					RunScript.execute(connection, new FileReader(script));
				} catch (FileNotFoundException e) {
					throw new RuntimeException("could not initialize with script");
				}
			}
		});
	}

	@AfterClass
	public static void tearDown() {
		em.clear();
		em.close();
		emf.close();
	}

	

}