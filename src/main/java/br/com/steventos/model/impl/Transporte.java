package br.com.steventos.model.impl;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.CascadeType.DETACH;
import static javax.persistence.FetchType.EAGER;

import java.math.BigDecimal;
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
@Table(name = "TRANSPORTE")
public class Transporte extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Column(nullable = false)
	private BigDecimal valor;
	
	@ManyToOne(fetch = EAGER, cascade = DETACH)
	@JoinColumn(name = "local_origem_id")
	private Local origem;

	@ManyToOne(fetch = EAGER, cascade = DETACH)
	@JoinColumn(name = "local_destino_id")
	private Local destino;

	@JsonIgnore
	@ManyToMany(cascade = ALL, targetEntity = Pessoa.class)
	@JoinTable(name = "TRANSPORTE_PESSOA", joinColumns = { @JoinColumn(name = "TRANSPORTE_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PESSOA_ID") })
	private Set<Pessoa> pessoas;

	public Set<Pessoa> getPessoas() {
		return pessoas;
	}

	public void setPessoas(Set<Pessoa> pessoas) {
		this.pessoas = pessoas;
	}

	public Local getOrigem() {
		return this.origem;
	}

	public void setOrigem(Local origem) {
		this.origem = origem;
	}

	public Local getDestino() {
		return this.destino;
	}

	public void setDestino(Local destino) {
		this.destino = destino;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}
}
