package br.com.steventos.model.impl;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.FetchType.EAGER;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.steventos.model.BaseModel;

@Entity
@Table(name = "HOSPEDAGEM")
public class Hospedagem extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String nome;

	@ManyToOne(fetch = EAGER, cascade = DETACH)
	@JoinColumn(name = "local_id")
	private Local local;
	
	@JsonIgnore
	@ManyToMany(cascade = ALL, targetEntity = Pessoa.class)
	@JoinTable(name = "HOSPEDAGEM_PESSOA", joinColumns = { @JoinColumn(name = "HOSPEDAGEM_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PESSOA_ID") })
	private Set<Pessoa> pessoas;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Set<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}
	
	public Local getLocal() {
		return this.local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}
}
