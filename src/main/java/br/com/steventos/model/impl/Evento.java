package br.com.steventos.model.impl;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.FetchType.EAGER;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.steventos.model.BaseModel;

@Entity
@Table(name = "EVENTO")
public class Evento extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String nome;

	@Column(nullable = false)
	private String descricao;

	@Column(nullable = false)
	private Date dataIni;

	@Column(nullable = false)
	private Date dataFim;

	@NotNull
	@ManyToOne(fetch = EAGER, cascade = DETACH)
	@JoinColumn(name = "local_id")
	private Local local;

	@JsonIgnore
	@ManyToMany(cascade = ALL, targetEntity = Pessoa.class)
	@JoinTable(name = "EVENTO_PESSOA", joinColumns = { @JoinColumn(name = "EVENTO_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PESSOA_ID") })
	private Set<Pessoa> pessoas;

	public Date getDataIni() {
		return dataIni;
	}

	public void setDataIni(Date dataIni) {
		this.dataIni = dataIni;
	}

	public Date getDataFim() {
		return dataFim;
	}

	public void setDataFim(Date dataFim) {
		this.dataFim = dataFim;
	}

	public Local getLocal() {
		return this.local;
	}

	public void setLocal(Local local) {
		this.local = local;
	}

	public Set<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Set<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}
