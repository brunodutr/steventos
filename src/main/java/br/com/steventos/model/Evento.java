package br.com.steventos.model;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.GenerationType.AUTO;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

@Entity
@Table(name = "EVENTO")
public class Evento implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long id;

	private String nome;

	private String descricao;

	private Date dataIni;

	private Date dataFim;

	private String cidade;

	@JsonIgnore
	@ManyToMany(cascade = ALL, targetEntity = Pessoa.class)
	@JoinTable(name = "EVENTO_PESSOA", joinColumns = { @JoinColumn(name = "EVENTO_ID") }, inverseJoinColumns = {
			@JoinColumn(name = "PESSOA_ID") })
	private Set<Pessoa> pessoas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

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

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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
