package br.com.steventos.model.impl;

import static javax.persistence.CascadeType.ALL;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.steventos.model.BaseModel;

@Entity
@Table(name = "PESSOA")
public class Pessoa extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String nome;

	private Date dataNascimento;

	@Column(unique = true)
	private String email;

	@JsonIgnore
	@ManyToMany(cascade = ALL, targetEntity = Evento.class)
	@JoinTable(name = "EVENTO_PESSOA", joinColumns = { @JoinColumn(name = "PESSOA_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "EVENTO_ID") })
	private Set<Evento> eventos;

	@JsonIgnore
	@ManyToMany(cascade = ALL, targetEntity = Transporte.class)
	@JoinTable(name = "TRANSPORTE_PESSOA", joinColumns = { @JoinColumn(name = "PESSOA_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "TRANSPORTE_ID") })
	private Set<Transporte> transportes;

	@JsonIgnore
	@ManyToMany(cascade = ALL, targetEntity = Hospedagem.class)
	@JoinTable(name = "HOSPEDAGEM_PESSOA", joinColumns = { @JoinColumn(name = "PESSOA_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "HOSPEDAGEM_ID") })
	private Set<Hospedagem> hospedagens;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Set<Evento> getEventos() {
		if (this.eventos == null) {
			this.eventos = new HashSet<>();
		}
		return eventos;
	}

	public void setEventos(Set<Evento> eventos) {
		this.eventos = eventos;
	}

	public Set<Transporte> getTransportes() {
		if (this.transportes == null) {
			this.transportes = new HashSet<>();
		}
		return transportes;
	}

	public void setTransportes(Set<Transporte> transportes) {
		this.transportes = transportes;
	}

	public Set<Hospedagem> getHospedagens() {
		if (this.hospedagens == null) {
			this.hospedagens = new HashSet<>();
		}
		return hospedagens;
	}

	public void setHospedagens(Set<Hospedagem> hospedagem) {
		this.hospedagens = hospedagem;
	}

}
