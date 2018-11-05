package br.com.steventos.model.impl;

import static javax.persistence.CascadeType.ALL;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;

import br.com.steventos.model.BaseModel;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Entity
@Table(name = "LOCAL", uniqueConstraints = { @UniqueConstraint(columnNames = { "cidade", "estado" }) })
public class Local extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(nullable = false)
	private String cidade;

	@Column(nullable = false, length = 2)
	private String estado;

	@JsonIgnore
	@OneToMany(mappedBy = "local", cascade = ALL, orphanRemoval = true)
	private List<Evento> eventos;

	@JsonIgnore
	@OneToMany(mappedBy = "local", cascade = ALL, orphanRemoval = true)
	private List<Hospedagem> hospedagens;

	@JsonIgnore
	@OneToMany(mappedBy = "origem", cascade = ALL, orphanRemoval = true)
	private List<Transporte> origem_transportes;

	@JsonIgnore
	@OneToMany(mappedBy = "destino", cascade = ALL, orphanRemoval = true)
	private List<Transporte> destino_transportes;

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public List<Evento> getEventos() {
		return eventos;
	}

	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}

	public List<Transporte> getOrigem_transportes() {
		return origem_transportes;
	}

	public void setOrigem_transportes(List<Transporte> origem_transportes) {
		this.origem_transportes = origem_transportes;
	}

	public List<Transporte> getDestino_transportes() {
		return destino_transportes;
	}

	public void setDestino_transportes(List<Transporte> destino_transportes) {
		this.destino_transportes = destino_transportes;
	}

	public List<Hospedagem> getHospedagens() {
		return hospedagens;
	}

	public void setHospedagens(List<Hospedagem> hospedagens) {
		this.hospedagens = hospedagens;
	}

}
