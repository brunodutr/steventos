package br.com.steventos.model.impl;

import static javax.persistence.CascadeType.ALL;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.codehaus.jackson.annotate.JsonIgnore;

import br.com.steventos.model.BaseModel;

@Entity
@Table(name = "LOCAL", uniqueConstraints = { @UniqueConstraint(columnNames = { "cidade", "estado" }) })
public class Local extends BaseModel {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private String cidade;

	private String estado;

	@JsonIgnore
	@OneToMany(mappedBy = "local", cascade = ALL, orphanRemoval = true)
	private List<Evento> eventos;

	@JsonIgnore
	@OneToMany(mappedBy = "local", cascade = ALL, orphanRemoval = true)
	private List<Hospedagem> hospedagens;

	@JsonIgnore
	@OneToMany(mappedBy = "origem", cascade = ALL, orphanRemoval = true)
	private List<Transporte> transportes_origem;

	@JsonIgnore
	@OneToMany(mappedBy = "destino", cascade = ALL, orphanRemoval = true)
	private List<Transporte> transportes_destino;

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

	public List<Hospedagem> getHospedagens() {
		return hospedagens;
	}

	public void setHospedagens(List<Hospedagem> hospedagens) {
		this.hospedagens = hospedagens;
	}

	public List<Transporte> getTransportes_origem() {
		return transportes_origem;
	}

	public void setTransportes_origem(List<Transporte> transportes_origem) {
		this.transportes_origem = transportes_origem;
	}

	public List<Transporte> getTransportes_destino() {
		return transportes_destino;
	}

	public void setTransportes_destino(List<Transporte> transportes_destino) {
		this.transportes_destino = transportes_destino;
	}
}
