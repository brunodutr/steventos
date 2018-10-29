package br.com.steventos.model;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PESSOA")
public class Pessoa implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = IDENTITY)
	private Long id;

	private String nome;

	private LocalDate dataNascimento;

	private String email;

//	@JsonbTransient
//	@ManyToMany(cascade = ALL)
//	@JoinTable(name = "EVENTO_PESSOA", joinColumns = { @JoinColumn(name = "EVENTO_ID") }, inverseJoinColumns = {
//			@JoinColumn(name = "PESSOA_ID") })
//	private Set<Evento> eventos;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public LocalDate getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

//	public Set<Evento> getEventos() {
//		return eventos;
//	}
//
//	public void setEventos(Set<Evento> eventos) {
//		this.eventos = eventos;
//	}

}
